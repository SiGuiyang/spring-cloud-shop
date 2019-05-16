package quick.pager.shop;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
@RestController
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String sql = "select id, service_id, profile, label, app_key, app_value from t_config";

    @GetMapping("/toJdbc")
    public String toJdbc() {
        List<Config> configs = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Config.class));

        Map<String, List<Config>> collect = configs.stream().collect(Collectors.groupingBy(Config::getServiceId));

        collect.forEach((k, v) -> {
            System.out.println();
            v.forEach(config -> {
                StringBuilder builder = new StringBuilder("insert into t_config(service_id, profile, label, app_key, app_value) values(");
                builder.append("'").append(config.getServiceId()).append("'")
                        .append(",'").append(config.getProfile()).append("'")
                        .append(",'").append(config.getLabel()).append("'")
                        .append(",'").append(config.getAppKey()).append("'")
                        .append(",'").append(config.getAppValue()).append("')");
                System.out.println(builder.toString());
            });

        });
        return "success";
    }

    public static class Config {
        private Integer id;

        private String serviceId;

        private String profile;

        private String label;

        private String appKey;

        private String appValue;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getAppKey() {
            return appKey;
        }

        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }

        public String getAppValue() {
            return appValue;
        }

        public void setAppValue(String appValue) {
            this.appValue = appValue;
        }
    }
}
