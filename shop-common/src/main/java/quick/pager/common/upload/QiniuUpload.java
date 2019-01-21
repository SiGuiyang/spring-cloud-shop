package quick.pager.common.upload;

import java.io.File;
import java.io.InputStream;

/**
 * 七牛文件上传
 */
public class QiniuUpload {

    private static final String URL = "http://pk6b0a7n8.bkt.clouddn.com/";

    /**
     * 上传文件
     *
     * @param file   上传的文件
     * @param folder 文件路径
     * @return 文件全路径
     */
    public static String uploadToFile(File file, String folder) {
        return URL + UploadConfiguration.uploadFile(file, folder);
    }

    /**
     * 数据流文件上传
     *
     * @param is       输入流
     * @param fileName 上传文件名
     * @return 文件全路径
     */
    public static String uploadToStream(InputStream is, String fileName) {
        return URL + UploadConfiguration.uploadStream(is, fileName);
    }

    /**
     * 字节数组上传
     *
     * @param data     字节数组
     * @param fileName 文件名
     * @return 文件全路径
     */
    public static String uploadToByte(byte[] data, String fileName) {
        return URL + UploadConfiguration.uploadToByte(data, fileName);
    }
}