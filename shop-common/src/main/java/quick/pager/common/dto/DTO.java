package quick.pager.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DTO implements Serializable {

    private static final long serialVersionUID = -1027750679708024114L;

    private Long id;

    private String event;

    private Integer pageSize;

    private Integer page;

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
