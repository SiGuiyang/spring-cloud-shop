package quick.pager.common.upload;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import quick.pager.common.constants.SysConfigKeys;
import quick.pager.common.utils.SysConfigMap;

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
        Configuration configuration = new Configuration(Zone.autoZone());
        return new UploadManager(configuration);
    }

    static String uploadStream(InputStream is, String fileName) {
        UploadManager uploadManager = UploadConfiguration.getUploadManager();
        try {

            Response response = uploadManager.put(is, DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN) + "/" + fileName, UploadConfiguration.getToken(), null, null);
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
        if (StrUtil.isNotBlank(folder)) {
            builder.append(folder);
        }
        builder.append(file.getName());

        try {
            Response response = uploadManager.put(file, builder.toString(), UploadConfiguration.getToken());
            if (response.isOK()) {
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                return putRet.key;
            }

        } catch (QiniuException e) {
            throw new RuntimeException("上传文件失败");
        }
        return null;
    }

    /**
     * 字节数组上传
     *
     * @param datas    字节数组
     * @param fileName 文件名
     */
    static String uploadToByte(byte[] datas, String fileName) {
        UploadManager uploadManager = UploadConfiguration.getUploadManager();
        try {
            Response response = uploadManager.put(datas, fileName, UploadConfiguration.getToken());
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
