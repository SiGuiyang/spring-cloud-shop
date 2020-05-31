package quick.pager.shop.oss.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 阿里云OSS配置
 *
 * @author siguiyang
 */
@Data
@ConfigurationProperties(prefix = "shop.oss")
public class OSSProperties {

    /**
     * http://pager-static.oss-accelerate.aliyuncs.com
     */
    private String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    // accessKeyId和accessKeySecret是OSS的访问密钥，您可以在控制台上创建和查看，
    // 创建和查看访问密钥的链接地址是：https://ak-console.aliyun.com/#/。
    // 注意：accessKeyId和accessKeySecret前后都没有空格，从控制台复制时请检查并去除多余的空格。
    // LTAI4G7cyWJMo2dsEKtypcen
    private String accessKeyId = "<yourAccessKeyId>";
    // UIsJeLhmK944HJAGxWaxuoTWTs4iHf
    private String accessKeySecret = "<yourAccessKeySecret>";
    // Bucket用来管理所存储Object的存储空间，详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
    // Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
    // pager-static
    private String bucketName = "<yourBucketName>";
    // Object是OSS存储数据的基本单元，称为OSS的对象，也被称为OSS的文件。详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
    // Object命名规范如下：使用UTF-8编码，长度必须在1-1023字节之间，不能以“/”或者“\”字符开头。
    private String firstKey = "my-first-key";

}
