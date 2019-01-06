package quick.pager.shop.model.activity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class InviteRewardRecord extends Model {

    private static final long serialVersionUID = 414513670760464045L;
    private Long inviteUserId;

    private Long userId;

    private String phone;

    private Integer rewardType;

}