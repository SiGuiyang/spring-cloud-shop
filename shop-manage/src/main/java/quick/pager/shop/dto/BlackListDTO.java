package quick.pager.shop.dto;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;


/**
* @author siguiyang
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class BlackListDTO extends ManageDTO {

    private static final long serialVersionUID = -1516608122938399919L;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
