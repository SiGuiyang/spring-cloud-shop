package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * Job Group 组
 *
 * @author siguiyang
 */
@TableName("QUARTZ_JOB_GROUP")
@Data
public class JobGroup implements Serializable {

    private static final long serialVersionUID = 1090717875144823104L;
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 组服务名称
     */
    private String groupName;
    /**
     * 序号
     */
    private Integer sequence;
}
