package quick.pager.shop.model.activity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class InviteCode extends Model {

    private static final long serialVersionUID = -7808875282757202205L;
    private Long userId;

    private Long templateId;

    private String code;


    private String createUser;

}
