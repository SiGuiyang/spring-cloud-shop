package quick.pager.shop.goods.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * name: "858ba9b8b33145c288477c2b0f2d790e.jpg"
 * status: "success"
 * uid: 1605958367686
 * url: "http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-11-21/858ba9b8b33145c288477c2b0f2d790e.jpg?Expires=1921318364&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=NKTnF8Y2H1wsy3QwZuOMDekDPP8%3D
 *
 * @author siguiyang
 */
@Data
public class UploadDTO implements Serializable {


    private static final long serialVersionUID = -7915251432478014371L;
    /**
     * 文件名称
     */
    private String name;
    /**
     * 上传状态
     */
    private String status;
    /**
     * 请求唯一标识
     */
    private Long uid;
    /**
     * 上传生成的文件地址
     */
    private String url;
}
