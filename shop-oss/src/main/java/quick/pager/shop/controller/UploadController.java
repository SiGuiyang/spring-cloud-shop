package quick.pager.shop.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.URLUtil;
import com.google.common.collect.Maps;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.enmus.OSSTypeEnum;
import quick.pager.shop.service.UploadService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.FileUtil;

/**
 * 上传 | 下载文件
 *
 * @author siguiyang
 */
@Slf4j
@RestController
@RequestMapping("/oss")
public class UploadController {
    @Autowired
    private Map<String, UploadService> uploadService;

    /**
     * 上传服务
     *
     * @param file    上传的文件
     * @param ossType 上传云服务器类型
     */
    @PostMapping("/upload")
    public Response<Map<String, String>> qiniuUpload(@RequestParam MultipartFile file, @RequestParam(required = false) String ossType) throws IOException {

        if (StringUtils.isEmpty(ossType)) {
            ossType = OSSTypeEnum.ALIYUN.getCode();
        }
        if (this.uploadService.containsKey(ossType)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "未找到可用的云服务器");
        }

        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        String url = this.uploadService.get(ossType).uploadStream(inputStream, originalFilename);
        log.info("文件上传的URL = {}", url);
        Map<String, String> result = Maps.newConcurrentMap();
        result.put("name", originalFilename);
        result.put("url", url);
        return new Response<>(result);
    }

    /**
     * 下载文件服务
     *
     * @param downloadFile     下载的文件路径
     * @param downloadFilename 下载文件的名称
     * @param response         响应流
     */
    @GetMapping("/download")
    public void download(@RequestParam String downloadFile, @RequestParam String downloadFilename, HttpServletResponse response) throws Exception {

        //得到要下载的文件
        String suffix = downloadFile.substring(downloadFile.lastIndexOf("."));
        String transFilename = DateUtil.formatDate(new Date()) + "-" + downloadFilename + suffix;

        //设置响应头，控制浏览器下载该文件
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-disposition", "attachment;filename=" + URLUtil.encode(transFilename, "UTF-8"));

        // 文件输入流
        DataInputStream in = FileUtil.getRemoteFile(downloadFile);
        //创建输出流
        OutputStream out = response.getOutputStream();

        FileUtil.write(in, out);

    }
}
