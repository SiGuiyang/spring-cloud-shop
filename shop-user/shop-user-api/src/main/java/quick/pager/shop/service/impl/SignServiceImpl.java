package quick.pager.shop.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.service.SignService;
import quick.pager.shop.user.constants.UserRedisKeys;
import quick.pager.shop.utils.DateUtils;

@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public boolean sign(Long userId, LocalDateTime dateTime) {

        int offset = dateTime.getDayOfMonth() - 1;

        return redisTemplate.opsForValue().setBit(buildSignKey(userId, dateTime), offset, true);
    }

    @Override
    public int getSignDays(Long userId, LocalDateTime dateTime) {

        int count = 0;

        int bound = dateTime.getDayOfMonth();

        BitFieldSubCommands fieldSubCommands = BitFieldSubCommands.create();
        fieldSubCommands.get(BitFieldSubCommands.BitFieldType.INT_32);

        List<Long> result = redisTemplate.opsForValue().bitField(buildSignKey(userId, dateTime), fieldSubCommands);

        if (CollectionUtils.isNotEmpty(result)) {
            long value = null == result.get(IConsts.ZERO) ? IConsts.ZERO : result.get(IConsts.ZERO);

            for (int i = 0; i < bound; i++) {
                if (value >> 1 << 1 == value) {
                    if (i > 0) {
                        break;
                    }
                } else {
                    count++;
                }
                value >>= 1;
            }
        }
        return count;
    }

    /**
     * 构建redis签到key
     *
     * @param userId   用户主键
     * @param dateTime 时间
     * @return redis key
     */
    private String buildSignKey(final Long userId, final LocalDateTime dateTime) {
        return UserRedisKeys.SIGN + userId + ":" + DateUtils.format(dateTime, DateUtils.PURE_MONTH_PATTERN);
    }
}
