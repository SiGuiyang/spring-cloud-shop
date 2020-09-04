package quick.pager.shop.service;

import java.io.File;
import java.io.InputStream;

/**
 * 上传服务
 *
 * @author siguiyang
 */
public interface UploadService {

    /**
     * 上传文件
     *
     * @param is
     * @param fileName
     * @return
     */
    String uploadStream(InputStream is, String fileName);


    /**
     * 上传文件
     *
     * @param file
     * @param folder
     * @return
     */
    String uploadFile(File file, String folder);

    /**
     * 字节数组上传
     *
     * @param data     字节数组
     * @param fileName 文件名
     */
    String uploadToByte(byte[] data, String fileName);
}
