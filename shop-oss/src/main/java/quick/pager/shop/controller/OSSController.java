package quick.pager.shop.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.URLUtil;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import quick.pager.shop.configuration.OSSContext;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.enmus.OSSTypeEnum;
import quick.pager.shop.service.OSSService;
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
public class OSSController {

    /**
     * 上传服务
     *
     * @param file    上传的文件
     * @param ossType 上传云服务器类型
     */
    @PostMapping("/upload")
    public Response<Map<String, String>> upload(@RequestParam MultipartFile file, @RequestParam(required = false) String ossType) throws IOException {

        OSSTypeEnum ossTypeEnum = OSSTypeEnum.ALIYUN;
        if (StringUtils.isNotEmpty(ossType)) {
            ossTypeEnum = Enum.valueOf(OSSTypeEnum.class, ossType);
        }

        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        final OSSTypeEnum finalOssTypeEnum = ossTypeEnum;

        Optional<OSSService> optional = OSSContext.getBeans(OSSService.class).stream().filter(item -> item.support(finalOssTypeEnum)).findFirst();


        Map<String, String> result = Maps.newConcurrentMap();
        if (optional.isPresent()) {
            String url = optional.get().uploadStream(inputStream, originalFilename);
            log.info("文件上传的URL = {}", url);
            result.put("name", originalFilename);
            result.put("url", url);
        } else {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "未找到可用的云服务器");
        }

        return Response.toResponse(result);
    }

    /**
     * 下载文件服务
     *
     * @param ossKey   下载的文件路径
     * @param fileName 下载文件的名称
     * @param ossType  上传云服务器类型
     * @param response 响应流
     */
    @GetMapping("/download")
    public void download(@RequestParam(required = false) String ossKey,
                         @RequestParam(required = false) String fileName,
                         @RequestParam(required = false) String ossType,
                         HttpServletResponse response) throws Exception {

        //得到要下载的文件
        String suffix = ossKey.substring(ossKey.lastIndexOf("."));
        String transFilename = DateUtil.formatDate(new Date()) + "-" + fileName + suffix;

        //设置响应头，控制浏览器下载该文件
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + URLUtil.encode(transFilename, "UTF-8"));

        final OSSTypeEnum finalOssTypeEnum = Enum.valueOf(OSSTypeEnum.class, ossType);

        Optional<OSSService> optional = OSSContext.getBeans(OSSService.class).stream().filter(item -> item.support(finalOssTypeEnum)).findFirst();

        if (optional.isPresent()) {
            // 文件输入流
            InputStream in = optional.get().download(ossKey);
            //创建输出流
            OutputStream out = response.getOutputStream();

            FileUtil.write(in, out);
        }
    }
}
