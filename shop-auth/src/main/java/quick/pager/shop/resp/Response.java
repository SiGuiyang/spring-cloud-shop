package quick.pager.shop.resp;

import java.io.Serializable;

/**
 * 数据响应类<br />
 * code 201 未登陆
 * code 202 用户不存在
 * code 203 密码不正确
 * code 204 登陆过期
 *
 * @param <T>
 * @author siguiyang
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 473372815866107289L;
    /**
     * 数据响应吗
     */
    private int code = 200;
    /**
     * 响应消息
     */
    private String msg = "操作成功";
    /**
     * 响应数据
     */
    private T data;

    private long timestamp = System.currentTimeMillis();

    public Response() {
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(T data) {
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
