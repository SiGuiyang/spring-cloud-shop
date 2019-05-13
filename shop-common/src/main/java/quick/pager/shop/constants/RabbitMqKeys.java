package quick.pager.shop.constants;

/**
 * rabbit MQ 常量
 *
 * @author siguiyang
 */
public interface RabbitMqKeys {

    String TOPIC_EXCHANGE = "topicExchange";
    // TOPIC
    String TOPIC_COMMON = "topic.#";
    // 短信发送队列
    String SEND_SMS = "sendSMS";

    String TOPIC_TEST = "topic.test";
    // 好友邀请奖励
    String TOPIC_INVITE_FRIEND_AWARD = "topic.invite_friend_award";
}
