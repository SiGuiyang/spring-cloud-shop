package quick.pager.shop.utils;

import com.alibaba.fastjson.JSON;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringUtils;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDateTime;
import quick.pager.shop.constants.SysConfigKeys;

/**
 * 七牛存储配置
 *
 * @author siguiyang
 */
class UploadConfiguration {

    /**
     * 获取上传的token值
     */
    private static String getToken() {

        Auth auth = Auth.create(SysConfigMap.get(SysConfigKeys.QINIU_ACCESS_KEY), SysConfigMap.get(SysConfigKeys.QINIU_SECRET_KEY));

        return auth.uploadToken(SysConfigMap.get(SysConfigKeys.QINIU_BUCKET));
    }


    /**
     * 获取设置的UploadManager配置中心
     */
    private static UploadManager getUploadManager() {
        Configuration configuration = new Configuration(Region.region0());
        return new UploadManager(configuration);
    }

    static String uploadStream(InputStream is, String fileName) {
        UploadManager uploadManager = UploadConfiguration.getUploadManager();
        try {

            String key = SysConfigMap.get(SysConfigKeys.QINIU_BUCKET) + '/' + DateUtils.format(LocalDateTime.now(), DateUtils.NORM_DATE_PATTERN) + "/" + fileName;
            Response response = uploadManager.put(is, key, UploadConfiguration.getToken(), null, null);
            if (response.isOK()) {
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                return putRet.key;
            }

        } catch (QiniuException e) {
            throw new RuntimeException("上传文件失败");
        }
        return null;
    }

    static String uploadFile(File file, String folder) {
        UploadManager uploadManager = UploadConfiguration.getUploadManager();

        if (!file.exists()) {
            throw new RuntimeException("上传的文件不存在");
        }
        StringBuilder builder = new StringBuilder();
        if (!StringUtils.isNullOrEmpty(folder)) {
            builder.append(folder);
        }
        builder.append(file.getName());

        try {
            Response response = uploadManager.put(file, builder.toString(), UploadConfiguration.getToken());
            if (response.isOK()) {
                return JSON.parseObject(response.bodyString(), DefaultPutRet.class).key;
            }

        } catch (QiniuException e) {
            throw new RuntimeException("上传文件失败");
        }
        return null;
    }

    /**
     * 字节数组上传
     *
     * @param data     字节数组
     * @param fileName 文件名
     */
    static String uploadToByte(byte[] data, String fileName) {
        UploadManager uploadManager = UploadConfiguration.getUploadManager();
        try {
            Response response = uploadManager.put(data, fileName, UploadConfiguration.getToken());
            if (response.isOK()) {
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                return putRet.key;
            }
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return null;
    }
}
