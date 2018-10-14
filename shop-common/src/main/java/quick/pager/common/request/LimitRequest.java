package quick.pager.common.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页请求基类
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LimitRequest extends Request {
    private static final long serialVersionUID = -8989796076245602142L;

    /**
     * 一页的大小
     */
    private Integer pageSize;
    /**
     * 页码
     */
    private Integer pageNum;
}
