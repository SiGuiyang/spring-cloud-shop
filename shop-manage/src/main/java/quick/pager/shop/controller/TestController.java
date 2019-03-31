package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.upload.QiniuUpload;

@Api(description = "接口级功能性测试")
@RestController
public class TestController {

    @GetMapping("/test/qiniu")
    public String test() {
        String s = null;
        try {
            s = QiniuUpload.uploadToStream(new FileInputStream("/Users/siguiyang/Downloads/mangguo.jpg"), "demo.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print(s);
        return s;
    }
}
