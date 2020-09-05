package quick.pager.shop.response.system;

import com.alibaba.excel.annotation.ExcelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import quick.pager.shop.excel.LocalDateTimeConverter;

/**
 * 导出Excel对象
 */
@Data
public class SysUserDownloadResponse implements Serializable {
    private static final long serialVersionUID = 3895670122382607462L;

    @ExcelProperty("用户名")
    private String username;
    @ExcelProperty("手机号码")
    private String phone;
    @ExcelProperty("角色")
    private String role;
    @ExcelProperty("是否是管理员")
    private String admin;
    @ExcelProperty(value = "创建时间", converter = LocalDateTimeConverter.class)
    private LocalDateTime createTime;
}
