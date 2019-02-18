package quick.pager.shop.user.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.handler.AbstractHandler;
import quick.pager.common.response.Response;

@Component
public class TestHandler01 extends AbstractHandler<String> {

    @Override
    public Response<String> doHandler(Object obj) {

        Response<String> response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        System.out.println(JSON.toJSONString(response));
        System.out.println(obj);
        return response;
    }
}
