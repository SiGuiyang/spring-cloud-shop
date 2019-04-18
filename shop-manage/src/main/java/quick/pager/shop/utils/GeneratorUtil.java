package quick.pager.shop.utils;

import cn.hutool.extra.template.Engine;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.model.Columns;
import quick.pager.shop.model.GeneratorConfig;

/**
 * 代码生成
 *
 * @author siguiyang
 */
@Slf4j
public class GeneratorUtil {


    private static final String PK = "PRI";

    private static final String PK_MYBATIS = "#{id, jdbcType=BIGINT}";

    private static List<String> BACKEND_TEMPLATE = Lists.newArrayList();

    private static List<String> FRONT_TEMPLATE = Lists.newArrayList();

    static {

        BACKEND_TEMPLATE.add("Entity");
        BACKEND_TEMPLATE.add("DTO");
        BACKEND_TEMPLATE.add("Mapper");
        BACKEND_TEMPLATE.add("Service");
        BACKEND_TEMPLATE.add("Controller");
        BACKEND_TEMPLATE.add("Xml");

        FRONT_TEMPLATE.add("api");
        FRONT_TEMPLATE.add("index");
        FRONT_TEMPLATE.add("IForm");

    }

    /**
     * 生成代码
     *
     * @param columnInfos 表元数据
     * @param config      生成代码的参数配置，如包路径，作者
     */
    public static void generatorCode(List<Columns> columnInfos, GeneratorConfig config, String tableName) throws Exception {
        Map<String, Object> map = Maps.newConcurrentMap();
        map.put("package", config.getPackagePath());
        map.put("moduleName", config.getModule());
        map.put("author", config.getAuthor());
        map.put("tableName", tableName);
        String className = StrUtils.toUpperCase(tableName);
        map.put("className", className);
        map.put("changeClassName", StrUtils.capitalize2CamelCase(tableName));
        map.put("hasQuery", false);

        List<Map<String, Object>> columns = new ArrayList<>();
        List<Map<String, Object>> queryColumns = new ArrayList<>();
        for (Columns column : columnInfos) {
            Map<String, Object> listMap = Maps.newConcurrentMap();
            listMap.put("columnComment", column.getColumnComment());
            listMap.put("columnKey", column.getColumnKey());

            String colType = ColumnUtil.column2Java(column.getDataType());
            String fieldName = StrUtils.capitalize2CamelCase(column.getColumnName());
            if (PK.equals(column.getColumnKey())) {
                listMap.put("pkColumnType", colType);
            } else {
                listMap.putIfAbsent("pkColumnType", "common");
            }
            listMap.put("dataType", column.getDataType().toUpperCase());
            listMap.put("columnType", colType);
            listMap.put("columnName", column.getColumnName());
            listMap.put("columnShow", column.isColumnDisplay());
            listMap.put("columnTitle", column.getColumnTitle());
            listMap.put("changeColumnName", fieldName);
            listMap.put("capitalColumnName", StrUtils.toUpperCase(column.getColumnName()));
            listMap.put("columnJdbcType", ColumnUtil.column2JdbcType(fieldName, column.getDataType().toUpperCase()));
            if (column.isQueryDisplay()) {
                listMap.put("columnQuery", column.isColumnDisplay());
                map.put("hasQuery", true);
                queryColumns.add(listMap);
            }
            columns.add(listMap);
        }
        map.put("columns", columns);
        map.put("queryColumns", queryColumns);
        map.put("id", PK_MYBATIS);
        Engine engine = TemplateUtil.createEngine(new TemplateConfig("/", TemplateConfig.ResourceMode.CLASSPATH));

        // 生成后端代码
        for (String templateName : BACKEND_TEMPLATE) {
            Template template = engine.getTemplate("generator/backend/" + templateName + ".ftl");
            String filePath = getFilePath(templateName, config, className);
            // 生成代码
            genFile(filePath, template, map);
        }

        // 生成前端代码
        for (String templateName : FRONT_TEMPLATE) {
            Template template = engine.getTemplate("generator/front/" + templateName + ".ftl");
            String filePath = getFilePath(templateName, config, map.get("changeClassName").toString());
            // 生成代码
            genFile(filePath, template, map);
        }
    }

    /**
     * 获取生成文件的路径
     *
     * @param templateName 模板名称
     * @param config       配置
     * @param module       模块
     */
    private static String getFilePath(String templateName, GeneratorConfig config, String module) {


        String path = System.getProperty("user.dir") + File.separator + config.getModule();
        String packagePath = path + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator;
        if (!ObjectUtils.isEmpty(config.getPackagePath())) {
            packagePath += config.getPackagePath().replace(".", File.separator) + File.separator;
        }

        String result = "";
        switch (templateName) {
            case "Entity":
                result = packagePath + "model" + File.separator + module + ".java";
                break;
            case "Controller":
                result = packagePath + "controller" + File.separator + module + "Controller.java";
                break;
            case "Service":
                result = packagePath + File.separator + module + "Service.java";
                break;
            case "DTO":
                result = packagePath + File.separator + "dto" + File.separator + module + "DTO.java";
                break;
            case "Mapper":
                result = packagePath + File.separator + "mapper" + File.separator + module + "Mapper.java";
                break;
            case "Xml":
                result = packagePath + File.separator + "mapper" + File.separator + module + "Mapper.xml";
                break;
            case "api":
                result = config.getFrontPath() + File.separator + module + ".js";
                break;
            case "index":
                result = config.getFrontPath() + File.separator + "index.vue";
                break;
            case "IForm":
                result = config.getFrontPath() + File.separator + "form.vue";
                break;
        }
        return result;
    }

    /**
     * 生成文件
     *
     * @param filePath 生成文件路径
     * @param template 模版
     * @param map      渲染数据
     */
    private static void genFile(String filePath, Template template, Map<String, Object> map) throws Exception {

        File file = new File(filePath);
        // 如果非覆盖生成
        if (cn.hutool.core.io.FileUtil.exist(file)) {
            return;
        }

        // 生成目标文件
        Writer writer = null;
        try {
            cn.hutool.core.io.FileUtil.touch(file);
            writer = new FileWriter(file);
            template.render(map, writer);

        } finally {
            if (null != writer) {
                writer.close();
            }
        }
    }
}
