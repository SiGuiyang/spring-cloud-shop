package quick.pager.shop.manage.response;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class MenuResponse implements Serializable {
    private static final long serialVersionUID = -7318452444752890387L;

    private Long id;
    private String permission;
    private String name;
    private Integer permissionType;
    private String createUser;
    private Date createTime;

    private List<MenuResponse> children = Lists.newArrayList();

}
