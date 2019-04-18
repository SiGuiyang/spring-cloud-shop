package quick.pager.shop.service;

import com.github.pagehelper.PageHelper;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.GeneratorDTO;
import quick.pager.shop.mapper.ColumnsMapper;
import quick.pager.shop.mapper.GeneratorConfigMapper;
import quick.pager.shop.mapper.TablesMapper;
import quick.pager.shop.model.Columns;
import quick.pager.shop.model.GeneratorConfig;
import quick.pager.shop.model.Tables;
import quick.pager.shop.response.Response;
import quick.pager.shop.utils.GeneratorUtil;

@Service
@Slf4j
public class GeneratorService {

    @Autowired
    private ColumnsMapper columnsMapper;
    @Autowired
    private TablesMapper tablesMapper;
    @Autowired
    private GeneratorConfigMapper generatorConfigMapper;

    /**
     * 所有表
     */
    public Response tables(GeneratorDTO dto) {

        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        List<Tables> tables = tablesMapper.selectTables(dto.getTableSchema(), dto.getTableName());

        return Response.toResponse(tables);
    }

    /**
     * 某张表的元素信息
     *
     * @param tableSchema 数据库实例
     * @param tableName   表名
     */
    public Response<List<Columns>> tables(String tableSchema, String tableName) {
        List<Columns> columns = columnsMapper.selectColumns(tableSchema, tableName);
        return new Response<>(columns);
    }

    /**
     * 自动生成代码
     *
     * @param columns   表的元素信息
     * @param tableName 表名
     */
    public Response generator(List<Columns> columns, String tableName) {

        GeneratorConfig generatorConfig = generatorConfigMapper.selectGeneratorConfig();
        try {
            GeneratorUtil.generatorCode(columns, generatorConfig, tableName);
        } catch (Exception e) {
            log.error("生成代码失败");
            return new Response(ResponseStatus.Code.FAIL_CODE, "生成代码失败");
        }
        return new Response();
    }
}
