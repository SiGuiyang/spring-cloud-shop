package quick.pager.shop.manage.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class ConfigRequest extends ManageRequest {
    private static final long serialVersionUID = 5078408515906079875L;

    private String configName;

    private String configValue;

    private String module;

    private String description;
}
