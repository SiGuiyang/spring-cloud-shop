package quick.pager.common.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import quick.pager.common.constants.Constants;
import quick.pager.common.constants.ResponseStatus;

import java.io.Serializable;

/**
 * 数据响应类
 *
 * @param <T>
 * @author siguiyang
 */
@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 473372815866107289L;
    /**
     * 数据响应吗
     */
    private int code = ResponseStatus.Code.SUCCESS;
    /**
     * 响应消息
     */
    private String msg = ResponseStatus.SUCCESS_MSG;
    /**
     * 响应数据
     */
    private T data;
    /**
     * 分页总数
     */
    private long total;

    public Response() {
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(T data) {
        this.data = data;
    }

}
