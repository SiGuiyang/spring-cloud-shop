package quick.pager.shop.job.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;

/**
 * Job Group 组
 *
 * @author siguiyang
 */
@TableName("QUARTZ_JOB_GROUP")
@Data
public class JobGroup {

    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 组服务名称
     */
    private String appName;
    /**
     * 序号
     */
    private Integer orderType;
}
