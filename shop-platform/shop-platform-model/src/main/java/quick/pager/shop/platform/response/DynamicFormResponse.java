package quick.pager.shop.platform.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class DynamicFormResponse implements Serializable {
    private static final long serialVersionUID = -3549840077493754135L;

    private Long id;

    private String bizType;

    private String name;

    private String type;

    private String icon;

    private String model;

    private String defaultValue;

    private String width;

    private String remoteUrl;

    private String dataType;

    private String pattern;

    private String placeholder;

    private String startPlaceholder;

    private String endPlaceholder;

    private String format;

    private String customClass;

    private String rules;

    private Integer min;

    private Integer max;

    private Integer step;

    private Boolean beRange;

    private Boolean showInput;

    private Boolean arrowControl;

    private Boolean disabled;

    private Boolean inline;

    private Boolean readonly;

    private Boolean editable;

    private Boolean clearable;

    private Boolean timestamp;

    private Boolean allowHalf;

    private Boolean showAlpha;

    private Boolean multiple;

    private Boolean showLabel;

    private Boolean filterable;
}
