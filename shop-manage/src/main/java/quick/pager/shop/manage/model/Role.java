package quick.pager.shop.manage.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_role")
public class Role extends Model {

    private static final long serialVersionUID = -7967826509330583583L;

    private String roleName;

    private String roleCode;

}
