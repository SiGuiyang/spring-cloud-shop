package quick.pager.shop.job.enums;

import quick.pager.shop.enums.IEnum;

/**
 * job定时任务状态枚举
 *
 * @author siguiyang
 */
public enum JobStatusEnums implements IEnum<Integer> {
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

    private Integer code;

    private String desc;

    JobStatusEnums(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    public static JobStatusEnums parse(final int code) {
        for (JobStatusEnums jobStatusEnums : JobStatusEnums.values()) {
            if (jobStatusEnums.code == code) {
                return jobStatusEnums;
            }
        }
        return null;
    }
}
