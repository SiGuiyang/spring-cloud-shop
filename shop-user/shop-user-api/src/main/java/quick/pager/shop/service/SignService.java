package quick.pager.shop.service;

import java.time.LocalDateTime;

/**
 * 签到服务
 *
 * @author siguiyang
 */
public interface SignService {

    /**
     * 签到
     *
     * @param userId   用户主键
     * @param dateTime 时间
     */
    boolean sign(final Long userId, LocalDateTime dateTime);

    /**
     * 连续签到天数
     *
     * @param userId   用户主键
     * @param dateTime 时间
     */
    int getSignDays(final Long userId, LocalDateTime dateTime);
}
