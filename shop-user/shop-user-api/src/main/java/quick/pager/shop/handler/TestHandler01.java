package quick.pager.shop.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;

@Component
public class TestHandler01 extends AbstractHandler<String> {

    @Override
    public Response<String> doHandler(Object obj) {

        Response<String> response = Response.toError(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        System.out.println(JSON.toJSONString(response));
        System.out.println(obj);
        return response;
    }
}
