package quick.pager.shop.job.handler.core;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import quick.pager.shop.context.ShopSpringContext;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.enums.JobStatusEnums;
import quick.pager.shop.job.handler.AbstractHandler;
import quick.pager.shop.job.mapper.JobInfoMapper;
import quick.pager.shop.job.model.JobInfo;

/**
 * 执行执行器
 *
 * @author siguiyang
 */
@Slf4j
public class ExecuteHandler extends AbstractHandler {

    @Override
    public boolean support(JobEnums jobEnums) {
        return JobEnums.EXECUTE.equals(jobEnums);
    }

    @Override
    public void execute(Long jobId, String jobName) {

        // 1. 获取数据库执行的job任务
        JobInfoMapper jobInfoMapper = ShopSpringContext.getBean(JobInfoMapper.class);
        JobInfo jobInfo = new JobInfo();
        jobInfo.setJobName(jobName);
        jobInfo.setJobStatus(JobStatusEnums.NORMAL.getStatus());
        JobInfo selectJobInfo = jobInfoMapper.selectOne(new QueryWrapper<>(jobInfo));
        // 访问的资源请求地址
        String request;
        if (Objects.nonNull(selectJobInfo)) {
            Map<String, String> paramMap = new HashMap<>(8);
            StringBuilder builder = new StringBuilder("http://" + jobInfo.getServiceName() + jobInfo.getServiceMethod());
            if (!StringUtils.isEmpty(selectJobInfo.getParams())) {
                paramMap = JSON.parseObject(selectJobInfo.getParams(), Map.class);
                builder.append("?");
                for (Map.Entry<String, String> me : paramMap.entrySet()) {
                    String key = me.getKey();
                    builder.append(key).append("=").append("{").append(key).append("}").append("&");
                }

                request = builder.toString();
                // 如果是& 结尾，则取出& 之前的字符串
                if (request.endsWith("&")) {
                    request = request.substring(0, request.length() - 1);
                }
            } else {
                request = builder.toString();
            }
            RestTemplate template = ShopSpringContext.getBean(RestTemplate.class);
            ResponseEntity<String> responseEntity = template.getForEntity(request, String.class, paramMap);
            log.info("执行服务调用结束，返回结果 result = {}", JSON.toJSONString(responseEntity));
        }
    }
}
