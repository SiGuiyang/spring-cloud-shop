package quick.pager.common.response;

import lombok.Data;

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
    /**
     * 分页总数
     */
    private long total;
}
