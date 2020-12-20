package quick.pager.shop.service;

import java.io.File;
import java.io.InputStream;
import quick.pager.shop.enmus.OSSTypeEnum;

/**
 * 上传服务
 *
 * @author siguiyang
 */
public interface OSSService {

    /**
     * 支持ossType 类型
     *
     * @param ossType OSSType枚举
     * @return true 支持
     */
    boolean support(final OSSTypeEnum ossType);

    /**
     * 上传文件
     *
     * @param is       文件流
     * @param fileName 文件名称
     * @return 上传的文件路径
     */
    String uploadStream(final InputStream is, final String fileName);


    /**
     * 上传文件
     *
     * @param file     源文件
     * @param fileName 文件名称
     * @return 上传的文件路径
     */
    String uploadFile(final File file, final String fileName);

    /**
     * 字节数组上传
     *
     * @param data     字节数组
     * @param fileName 文件名
     * @return 上传的文件路径
     */
    String uploadToByte(final byte[] data, final String fileName);

    /**
     * 根据文件key下载获取文件流
     *
     * @param ossKey 文件key
     * @return
     */
    InputStream download(final String ossKey);
}
