package quick.pager.shop.platform.response;

import java.io.Serializable;
import lombok.Data;

/**
 * 短信模板
 *
 * @author siguiyang
 */
@Data
public class SMSTemplateResponse implements Serializable {
    private static final long serialVersionUID = -8587395071684162175L;

    /**
     * 所属模块
     */
    private String module;
    /**
     * 模板标识
     */
    private String templateCode;
    /**
     * 模板内容
     */
    private String templateContent;
}
