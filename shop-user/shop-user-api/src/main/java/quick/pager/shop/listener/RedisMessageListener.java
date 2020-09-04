package quick.pager.shop.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageListener implements MessageListener {

    private StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

    @Override
    public void onMessage(@NonNull Message message, @Nullable byte[] pattern) {

        byte[] body = message.getBody();//请使用valueSerializer
        byte[] channel = message.getChannel();
        String msg = stringRedisSerializer.deserialize(body);
        String topic = stringRedisSerializer.deserialize(channel);
        System.out.println("我是sub,监听" + topic + ",我收到消息：" + msg);

    }
}
