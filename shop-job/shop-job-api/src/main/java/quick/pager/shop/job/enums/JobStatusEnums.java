package quick.pager.shop.job.enums;

/**
 * job定时任务状态枚举
 *
 * @author siguiyang
 */
public enum JobStatusEnums {
    /**
     * 任务状态<br />
     * 0：暂停<br />
     * 1：删除<br />
     * 2：正常<br />
     */
    PAUSED(0, "暂停"),
    DELETE(1, "删除"),
    NORMAL(2, "正常"),
    ERROR(3, "错误"),
    COMPLETE(4, "完成"),
    BLOCKED(5, "阻塞"),
    NONE(6, "不存在");

    private Integer status;

    private String desc;

    JobStatusEnums(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
