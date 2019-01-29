package quick.pager.shop.feign.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassificationRequest extends Request {
    private static final long serialVersionUID = 8834227650288882046L;

    private String className;

    private String icon;

    private String createUser;
}
