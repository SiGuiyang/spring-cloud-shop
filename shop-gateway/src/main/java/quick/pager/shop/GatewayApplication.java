package quick.pager.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import quick.pager.shop.filter.LoginFilter;

@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(GatewayApplication.class);
        springApplication.run(args);
        System.out.println(springApplication.getWebApplicationType().name());
    }

    @Bean
    public RouteLocator route(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("shop-activity", p -> p.path("/activity/**").uri("lb://shop-activity"))
                .route("shop-goods", p -> p.path("/goods/**").uri("lb://shop-goods"))
                .route("shop-manage", p -> p.path("/admin/**").uri("lb://shop-manage"))
                .route("shop-auth", p -> p.path("/oauth/**").uri("lb://shop-auth"))
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

