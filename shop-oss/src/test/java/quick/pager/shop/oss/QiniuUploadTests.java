package quick.pager.shop.oss;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = OSSApplication.class)
public class QiniuUploadTests {

    private static final String url = "";
    private static final String filePath = "";

    @Test
    public void qiniuUpload() {

        Map<String, String> params = new HashMap<>();
        params.put("name", "测试");
        params.put("otherParam", "123456");
        httpClientUploadFile("http://127.0.0.1:9999/oss/qiniu/upload", new File("/Users/siguiyang/IdeaProjects/spring-cloud-shop/shop-oss/src/main/resources/banner.txt"), params);
    }


    public String httpClientUploadFile(String url, File file, Map<String, String> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        //每个post参数之间的分隔。随意设定，只要不会和其他的字符串重复即可。
        String boundary = "--------------20200103121104567";
        try {
            HttpPost httpPost = new HttpPost(url);
            //设置请求头
            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + boundary);

            //HttpEntity builder
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            //字符编码
            builder.setCharset(Charset.forName("UTF-8"));
            //模拟浏览器
//            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            //boundary
            builder.setBoundary(boundary);
            //multipart/form-data
            builder.addPart("file", new FileBody(file));//相当于<input name='file' type='file'/>
            // binary
//            builder.addBinaryBody("name=\"file\"; filename=\"test.txt\"", new FileInputStream(file), ContentType.MULTIPART_FORM_DATA, file.getName());// 文件流
            //其他参数
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.addTextBody(entry.getKey(), entry.getValue());
            }
            //HttpEntity
            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);
            // 执行提交
            HttpResponse response = httpClient.execute(httpPost);
            //响应
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.err.println("result" + result);
        return result;
    }

}
