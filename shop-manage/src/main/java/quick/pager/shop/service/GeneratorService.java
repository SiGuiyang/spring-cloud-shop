package quick.pager.shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.param.system.GeneratorPageParam;
import quick.pager.shop.mapper.GeneratorMapper;
import quick.pager.shop.model.Columns;
import quick.pager.shop.model.Tables;
import quick.pager.shop.user.response.Response;

/**
 * @author siguiyang
 */
@Service
@Slf4j
public class GeneratorService {

    @Autowired
    private GeneratorMapper generatorMapper;

    /**
     * 所有表
     */
    public Response tables(GeneratorPageParam dto) {

        QueryWrapper<Tables> qw = new QueryWrapper<>();
        if (StringUtils.isNotBlank(dto.getTableSchema())) {
            qw.eq("TABLE_SCHEMA", dto.getTableSchema());
        }
        if (StringUtils.isNotBlank(dto.getTableName())) {
            qw.eq("TABLE_NAME", dto.getTableName());
        }

        IPage<Tables> page = generatorMapper.selectTables(new Page<>(dto.getPage(), dto.getPageSize()), qw);
        return Response.toResponse(page.getRecords(), page.getTotal());
    }

    /**
     * 某张表的元素信息
     *
     * @param tableSchema 数据库实例
     * @param tableName   表名
     */
    public Response<List<Columns>> tables(String tableSchema, String tableName) {
        QueryWrapper<Columns> qw = new QueryWrapper<>();
        if (StringUtils.isNotBlank(tableSchema)) {
            qw.eq("TABLE_SCHEMA", tableSchema);
        }
        if (StringUtils.isNotBlank(tableName)) {
            qw.eq("TABLE_NAME", tableName);
        }
        List<Columns> columns = generatorMapper.selectColumns(qw);
        return Response.toResponse(columns);
    }

    /**
     * 自动生成代码
     *
     * @param tableSchema 数据库空间
     * @param tableName   表名
     */
    public Response generator(String tableSchema, String tableName) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/shop/src/main/java");
        gc.setAuthor(System.getProperty("user.name"));
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(MessageFormat.format("jdbc:mysql://localhost:3306/{0}?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&useSSL=false", tableSchema));
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("shop");
        pc.setParent("quick.pager.shop");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/shop/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("quick.pager.shop.model.Model");
        strategy.setEntityLombokModel(true);
        strategy.setInclude(tableName);
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

        return Response.toResponse();
    }
}
