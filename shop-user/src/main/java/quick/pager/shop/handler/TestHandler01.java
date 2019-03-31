package quick.pager.shop.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.handler.AbstractHandler;
import quick.pager.shop.response.Response;

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
