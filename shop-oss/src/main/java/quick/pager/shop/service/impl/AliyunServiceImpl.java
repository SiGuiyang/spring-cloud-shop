package quick.pager.shop.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectResult;
import java.io.File;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import quick.pager.shop.service.UploadService;

/**
 * 阿里云OSS
 *
 * @author siguiyang
 */
@Service("ALIYUN")
public class AliyunServiceImpl implements UploadService {

    @Autowired(required = false)
    private OSS oss;
    @Value("${alibaba.cloud.bucket}")
    private String bucket;

    @Override
    public String uploadStream(InputStream is, String fileName) {

        PutObjectResult result = oss.putObject(bucket, fileName, is);
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
