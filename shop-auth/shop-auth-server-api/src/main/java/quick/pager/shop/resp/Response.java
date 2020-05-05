package quick.pager.shop.resp;

import java.io.Serializable;
import lombok.Data;

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
@Data
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

    /**
     * 总数
     */
    private long total;

    private long timestamp = System.currentTimeMillis();

    public Response() {
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
