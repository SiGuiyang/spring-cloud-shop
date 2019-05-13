package quick.pager.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }

    @Bean
    public RouteLocator route(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("shop-manage", p -> p.path("/admin/**").uri("lb://shop-manage"))
                .route("shop-auth", p -> p.path("/oauth/**").uri("lb://shop-auth"))
                .route("shop-user", p -> p.path("/user/**").uri("lb://shop-user"))
                .route("shop-seller", p -> p.path("/seller/**").uri("lb://shop-seller"))

                .build();
    }

    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(1, 2);
    }

}

