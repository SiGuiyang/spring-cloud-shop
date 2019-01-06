package quick.pager.shop.manage.controller.common;

import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.common.upload.QiniuUpload;

/**
 * 上传
 */
@Api(description = "上传")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class UploadController {


    @ApiOperation("管理后端上传服务")
    @PostMapping("/upload")
    public Response<Map<String,String>> upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        String url = QiniuUpload.uploadToStream(inputStream, originalFilename);
        Map<String,String> result = Maps.newConcurrentMap();
        result.put("name",originalFilename);
        result.put("url",url);
        return new Response<>(result);
    }
}
