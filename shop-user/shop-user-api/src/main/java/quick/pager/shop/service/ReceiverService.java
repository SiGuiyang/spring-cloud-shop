package quick.pager.shop.service;

import org.springframework.stereotype.Service;

@Service
public class ReceiverService {

    public void onMessage(String message) {
        System.out.println("消息来了：" + message);

    }
}
