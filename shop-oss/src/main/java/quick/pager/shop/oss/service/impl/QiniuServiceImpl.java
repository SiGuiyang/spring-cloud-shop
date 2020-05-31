package quick.pager.shop.oss.service.impl;

import com.alibaba.fastjson.JSON;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringUtils;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import quick.pager.shop.oss.properties.QiniuProperties;
import quick.pager.shop.oss.service.UploadService;
import quick.pager.shop.utils.DateUtils;

/**
 * 七牛云OSS
 *
 * @author siguiyang
 */
@Service
@EnableConfigurationProperties(QiniuProperties.class)
public class QiniuServiceImpl implements UploadService {

    @Autowired(required = false)
    private UploadManager uploadManager;
    @Autowired(required = false)
    private Auth auth;
    @Autowired(required = false)
    private QiniuProperties qiniuProperties;

    @Override
    public String uploadStream(InputStream is, String fileName) {
        try {

            String key = qiniuProperties.getBucket() + '/' + DateUtils.format(LocalDateTime.now(), DateUtils.NORM_DATE_PATTERN) + "/" + fileName;
            Response response = uploadManager.put(is, key, this.getToken(), null, null);
            if (response.isOK()) {
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                return putRet.key;
            }

        } catch (QiniuException e) {
            throw new RuntimeException("上传文件失败");
        }
        return null;
    }

    @Override
    public String uploadFile(File file, String folder) {

        if (!file.exists()) {
            throw new RuntimeException("上传的文件不存在");
        }
        StringBuilder builder = new StringBuilder();
        if (!StringUtils.isNullOrEmpty(folder)) {
            builder.append(folder);
        }
        builder.append(file.getName());

        try {
            Response response = uploadManager.put(file, builder.toString(), this.getToken());
            if (response.isOK()) {
                return JSON.parseObject(response.bodyString(), DefaultPutRet.class).key;
            }

        } catch (QiniuException e) {
            throw new RuntimeException("上传文件失败");
        }
        return null;
    }


    @Override
    public String uploadToByte(byte[] data, String fileName) {
        try {
            Response response = uploadManager.put(data, fileName, this.getToken());
            if (response.isOK()) {
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                return putRet.key;
            }
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取上传token
     *
     * @return 上传token
     */
    private String getToken() {
        return auth.uploadToken(qiniuProperties.getBucket());
    }

}
