package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_invite_code")
public class InviteCode extends Model {

    private static final long serialVersionUID = -7808875282757202205L;
    private Long userId;

    private Long templateId;

    private String code;

}
