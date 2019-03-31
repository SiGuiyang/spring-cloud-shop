package quick.pager.shop.dto;

import lombok.Data;

import java.io.Serializable;

@Data
class DTO implements Serializable {

    private static final long serialVersionUID = -1027750679708024114L;

    /**
     * 服务主键Id
     */
    private Long id;

    /**
     * 操作类型事件
     */
    private String event;

    /**
     * 启用标志
     */
    private Boolean deleteStatus;
    /**
     * 操作人
     */
    private String createUser;

    public DTO() {
    }

    public DTO(Long id) {
        this.id = id;
    }
}
