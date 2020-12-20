package quick.pager.shop.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.constants.SConsts;
import quick.pager.shop.enmus.OSSTypeEnum;
import quick.pager.shop.service.OSSService;
import quick.pager.shop.utils.DateUtils;
import quick.pager.shop.utils.FileUtil;


/**
 * 阿里云OSS
 *
 * @author siguiyang
 */
@Service("ALIYUN")
@Slf4j
public class AliyunServiceImpl implements OSSService {

    @Autowired(required = false)
    private OSS oss;
    @Value("${alibaba.cloud.bucket}")
    private String bucket;

    @Override
    public boolean support(final OSSTypeEnum ossType) {
        return OSSTypeEnum.ALIYUN.equals(ossType);
    }

    @Override
    public String uploadStream(final InputStream is, final String fileName) {

        String url = null;
        String tempFileName = fileName;
        try {
            String suffix = tempFileName.substring(tempFileName.lastIndexOf(SConsts.POINT) + IConsts.ONE);
            // 上传的文件key
            tempFileName = suffix + SConsts.SLASH
                    + DateUtils.format(DateUtils.dateTime(), DateUtils.NORM_DATE_PATTERN)
                    + SConsts.SLASH + tempFileName;
            //创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(is.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(FileUtil.getContentType(SConsts.POINT + suffix));
            objectMetadata.setContentDisposition("inline;filename=" + tempFileName);

            oss.putObject(bucket, tempFileName, is, objectMetadata);

            // 获取oss 文件地址
            url = oss.generatePresignedUrl(bucket, tempFileName, new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10)).toString();

            log.info("上传后的地址 url = {}", url);
        } catch (Exception e) {
            log.error("上传文件失败");
        }
        return url;
    }

    @Override
    public String uploadFile(final File file, final String fileName) {
        try {
            return this.uploadStream(new FileInputStream(file), fileName);
        } catch (FileNotFoundException e) {
            log.error("源文件不存在，文件名称 fileName = {}", fileName);
        }
        return null;
    }

    @Override
    public String uploadToByte(final byte[] data, final String fileName) {
        return this.uploadStream(new ByteArrayInputStream(data), fileName);
    }

    @Override
    public InputStream download(final String ossKey) {

        OSSObject ossObject = oss.getObject(bucket, ossKey);
        return ossObject.getObjectContent();
    }
}
