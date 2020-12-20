package quick.pager.shop.user.response;

import java.util.List;
import lombok.Data;
import quick.pager.shop.constants.ResponseStatus;

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
    private int code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    private long timestamp = System.currentTimeMillis();

    /**
     * 分页总数
     */
    private long total;

    private Response() {
    }

    private Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(T data) {
        this.data = data;
    }

    public static <T> Response<List<T>> toResponse(List<T> data, long total) {
        Response<List<T>> response = new Response<>();
        response.setCode(ResponseStatus.Code.SUCCESS);
        response.setMsg(ResponseStatus.SUCCESS_MSG);
        response.setTotal(total);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> toResponse(T data) {
        Response<T> response = new Response<>();
        response.setCode(ResponseStatus.Code.SUCCESS);
        response.setMsg(ResponseStatus.SUCCESS_MSG);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> toResponse() {
        Response<T> response = new Response<>();
        response.setCode(ResponseStatus.Code.SUCCESS);
        response.setMsg(ResponseStatus.SUCCESS_MSG);
        return response;
    }

    public static <T> Response<T> toError(int code, String msg) {
        return new Response<>(code, msg);
    }

    public static <T> Response<T> toError(String msg) {
        return toError(ResponseStatus.Code.EXCEPTION_CODE, msg);
    }

    /**
     * 验证code是否成功
     */
    public boolean check() {
        return ResponseStatus.Code.SUCCESS == this.getCode();
    }
}
