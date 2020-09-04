package quick.pager.shop.handler.core;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import quick.pager.shop.context.ShopSpringContext;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.enums.JobStatusEnums;
import quick.pager.shop.handler.AbstractHandler;
import quick.pager.shop.mapper.JobInfoMapper;
import quick.pager.shop.model.JobInfo;

/**
 * 执行执行器
 *
 * @author siguiyang
 */
@Slf4j
public class ExecuteHandler extends AbstractHandler {

    @Override
    public boolean support(final JobEnums jobEnums) {
        return JobEnums.EXECUTE.equals(jobEnums);
    }

    @Override
    public void execute(final String jobName, final String jobGroup) {

        // 1. 获取数据库执行的job任务
        JobInfoMapper jobInfoMapper = ShopSpringContext.getBean(JobInfoMapper.class);
        JobInfo jobInfo = new JobInfo();
        jobInfo.setJobName(jobName);
        jobInfo.setJobStatus(JobStatusEnums.NORMAL.getCode());
        JobInfo selectJobInfo = jobInfoMapper.selectOne(new QueryWrapper<>(jobInfo));
        // 访问的资源请求地址
        if (Objects.nonNull(selectJobInfo)) {
            Map<String, String> paramMap = new ConcurrentHashMap<>();
            String url = "http://" + selectJobInfo.getServiceName() + selectJobInfo.getServiceMethod();
            if (!StringUtils.isEmpty(selectJobInfo.getParams())) {
                paramMap.putAll(JSON.parseObject(selectJobInfo.getParams(), Map.class));
            }
            OAuth2RestTemplate template = ShopSpringContext.getBean(OAuth2RestTemplate.class);
            // 得到服务鉴权访问token
            OAuth2AccessToken accessToken = template.getAccessToken();
            // 设置请求消息头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.setBearerAuth(accessToken.toString());
            // 得到 RestTemplate 访问的负载均衡对象
            RestTemplate restTemplate = ShopSpringContext.getBean("restTemplate", RestTemplate.class);
            ResponseEntity<Object> responseEntity = restTemplate.postForEntity(url, new HttpEntity<>(paramMap, headers), Object.class);
            log.info("执行服务调用结束，返回结果 result = {}", JSON.toJSONString(responseEntity));
        } else {
            log.error("未找到执行的定时任务 jobName = {}, jobGroup = {}", jobName, jobGroup);
        }
    }
}
