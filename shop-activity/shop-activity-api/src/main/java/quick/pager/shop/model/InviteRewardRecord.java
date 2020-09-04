package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_invite_reward_record")
public class InviteRewardRecord extends Model {

    private static final long serialVersionUID = 414513670760464045L;
    private Long inviteUserId;

    private Long userId;

    private String phone;

    private Integer rewardType;

}
