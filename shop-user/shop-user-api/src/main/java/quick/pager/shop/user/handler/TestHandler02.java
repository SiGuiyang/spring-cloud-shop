package quick.pager.shop.user.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.handler.AbstractHandler;
import quick.pager.shop.response.Response;

@Component
public class TestHandler02 extends AbstractHandler<Object> {

    @Override
    public Response<Object> doHandler(Object obj) {
        Response<Object> response = new Response<>(ResponseStatus.Code.SUCCESS, ResponseStatus.SUCCESS_MSG);
        System.out.println(JSON.toJSONString(response));
        System.out.println(obj);

        return response;
    }
}
