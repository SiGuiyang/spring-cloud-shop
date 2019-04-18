package quick.pager.shop.controller.common;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.URLUtil;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.upload.QiniuUpload;
import quick.pager.shop.utils.FileUtil;
//import quick.pager.shop.utils.FileUtil;

/**
 * 上传 | 下载文件
 */
@Api(description = "上传")
@Slf4j
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class UploadController {


    @ApiOperation("管理后端上传服务")
    @PostMapping("/upload")
    public Response<Map<String, String>> upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        String url = QiniuUpload.uploadToStream(inputStream, originalFilename);
        log.info("文件上传的URL = {}", url);
        Map<String, String> result = Maps.newConcurrentMap();
        result.put("name", originalFilename);
        result.put("url", url);
        return new Response<>(result);
    }

    @ApiOperation("管理后端下载文件服务")
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
