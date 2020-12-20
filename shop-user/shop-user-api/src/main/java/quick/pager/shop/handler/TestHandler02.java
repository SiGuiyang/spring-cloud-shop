package quick.pager.shop.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;

@Component
public class TestHandler02 extends AbstractHandler<Object> {

    @Override
    public Response<Object> doHandler(Object obj) {
        Response<Object> response = Response.toResponse();
        System.out.println(JSON.toJSONString(response));
        System.out.println(obj);

        return response;
    }
}
