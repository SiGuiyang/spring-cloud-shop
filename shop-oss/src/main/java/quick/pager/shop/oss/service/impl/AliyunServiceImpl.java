package quick.pager.shop.oss.service.impl;

import com.aliyun.oss.OSS;
import java.io.File;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import quick.pager.shop.oss.properties.OSSProperties;
import quick.pager.shop.oss.service.UploadService;

/**
 * 阿里云OSS
 *
 * @author siguiyang
 */
@Service
@EnableConfigurationProperties(OSSProperties.class)
public class AliyunServiceImpl implements UploadService {

    @Autowired(required = false)
    private OSS oss;
    @Autowired(required = false)
    private OSSProperties ossProperties;

    @Override
    public String uploadStream(InputStream is, String fileName) {

        oss.putObject(ossProperties.getBucketName(), ossProperties.getFirstKey(), is);
        return null;
    }

    @Override
    public String uploadFile(File file, String folder) {
        return null;
    }

    @Override
    public String uploadToByte(byte[] data, String fileName) {
        return null;
    }
}
