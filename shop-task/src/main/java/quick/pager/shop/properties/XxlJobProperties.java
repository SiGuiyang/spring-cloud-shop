package quick.pager.shop.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = XxlJobProperties.XXL_JOB)
public class XxlJobProperties {

    public static final String XXL_JOB = "quick.pager.shop.job.job";


    // quick.pager.shop.job-job admin address list, such as "http://address" or "http://address01,http://address02"
    private String adminAddress;


    private String accessToken;

    private String logPath;

    private int logRetentionDays;

    @NestedConfigurationProperty
    private Executor executor;


    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public int getLogRetentionDays() {
        return logRetentionDays;
    }

    public void setLogRetentionDays(int logRetentionDays) {
        this.logRetentionDays = logRetentionDays;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public static class Executor {
        // quick.pager.shop.job-job executor address
        private String appname;
        private String ip;
        private int port;

        public String getAppname() {
            return appname;
        }

        public void setAppname(String appname) {
            this.appname = appname;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }

}
