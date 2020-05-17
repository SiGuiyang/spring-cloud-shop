package quick.pager.shop.platform.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 短信模板
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_sms_template")
public class SMSTemplate extends Model {

    private static final long serialVersionUID = -2264345466177697910L;

    /**
     * 模板标识
     */
    private String templateCode;
    /**
     * 模板内容
     */
    private String templateContent;

}
