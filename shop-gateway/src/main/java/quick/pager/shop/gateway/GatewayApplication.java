package quick.pager.shop.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import quick.pager.shop.gateway.filter.LoginFilter;
import quick.pager.shop.gateway.filter.PermissionFilter;

@SpringBootApplication(scanBasePackages = {"quick.pager"})
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator route(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("shop-activity", p -> p.path("/activity/**").uri("lb://shop-activity"))
                .route("shop-goods", p -> p.path("/goods/**").uri("lb://shop-goods"))
                .route("shop-manage", p -> p.path("/admin/**").uri("lb://shop-manage").filters(new PermissionFilter()))
                .route("shop-auth", p -> p.path("/auth/**").uri("lb://shop-auth"))
                .route("shop-order", p -> p.path("/order/**").uri("lb://shop-order"))
                .route("shop-settlement", p -> p.path("/settlement/**").uri("lb://shop-settlement"))
                .route("shop-user", p -> p.path("/user/**").uri("lb://shop-user").filter(new LoginFilter()))
                .route("shop-seller", p -> p.path("/seller/**").uri("lb://shop-seller"))

                .build();
    }

    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(1, 2);
    }

}

