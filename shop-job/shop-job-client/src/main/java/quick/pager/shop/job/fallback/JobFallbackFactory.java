package quick.pager.shop.job.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.job.client.JobClient;
import quick.pager.shop.job.request.JobPageRequest;
import quick.pager.shop.job.request.JobRequest;
import quick.pager.shop.job.request.JobSaveRequest;
import quick.pager.shop.job.response.JobResponse;
import quick.pager.shop.user.response.Response;

@Component
@Slf4j
public class JobFallbackFactory implements FallbackFactory<JobClient> {
    @Override
    public JobClient create(Throwable cause) {
        return new JobClient() {
            @Override
            public Response<List<JobResponse>> page(JobPageRequest request) {
                return null;
            }

            @Override
            public Response<List<JobResponse>> list(JobRequest request) {
                return null;
            }

            @Override
            public Response<Long> modify(JobSaveRequest request) {
                return null;
            }

            @Override
            public Response<Long> create(JobSaveRequest request) {
                return null;
            }

            @Override
            public Response delete(Long jobId) {
                return null;
            }

            @Override
            public Response execute(Long jobId) {
                return null;
            }

            @Override
            public Response resume(Long jobId) {
                return null;
            }

            @Override
            public Response pause(Long jobId) {
                return null;
            }

            @Override
            public Response info(Long jobId) {
                return null;
            }
        };
    }
}
