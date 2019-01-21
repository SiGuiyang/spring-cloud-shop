package quick.pager.shop.zuul.properties;

import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "white.request-url")
@Component
@Data
public class PermissionProperties {

    private Map<String, String> permissions;

}
