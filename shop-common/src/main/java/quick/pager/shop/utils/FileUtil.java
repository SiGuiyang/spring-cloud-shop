package quick.pager.shop.utils;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * 文件工具类
 *
 * @author siguiyang
 */
public class FileUtil {

    /**
     * 获取远程文件流<br />
     * 接收类型为http 或者 https方式
     *
     * @param file 远程文件全路径
     */
    public static DataInputStream getRemoteFile(String file) throws Exception {
        URL url = new URL(file);
        return new DataInputStream(url.openStream());
    }

    /**
     * 文件输出复制
     *
     * @param in  输入流
     * @param out 输出流
     */
    public static void write(InputStream in, OutputStream out) throws Exception {
        //创建缓冲区
        byte[] buffer = new byte[1024];
        int len;
        //循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }

    /**
     * 获取文件的Content-Type
     *
     * @param filenameExtension 文件名称
     * @return Content-Type
     */
    public static String getContentType(String filenameExtension) {
        if (".bmp".equalsIgnoreCase(filenameExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(filenameExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(filenameExtension) ||
                ".jpg".equalsIgnoreCase(filenameExtension) ||
                ".png".equalsIgnoreCase(filenameExtension)) {
            return "image/jpg";
        }
        if (".html".equalsIgnoreCase(filenameExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(filenameExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(filenameExtension)) {
            return "application/vnd.visio";
        }
        if (".pptx".equalsIgnoreCase(filenameExtension) ||
                ".ppt".equalsIgnoreCase(filenameExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".docx".equalsIgnoreCase(filenameExtension) ||
                ".doc".equalsIgnoreCase(filenameExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(filenameExtension)) {
            return "text/xml";
        }
        return "image/jpg";
    }
}
