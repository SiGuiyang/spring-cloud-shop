package quick.pager.shop.feign.response;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class FightGroupMemberResponse implements Serializable{
    private static final long serialVersionUID = 1049531574585745121L;

    private Long id;

    private Long groupId;

    private Long recordId;

    private String phone;

    private String username;

    private Boolean master;

    private Date createTime;
}
