package quick.pager.shop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quick.pager.shop.filter.LoginFilter;

@Configuration
public class GatewayConfiguration {

    @Autowired
    private LoginFilter loginFilter;

    @Bean
    public RouteLocator route(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("shop-auth", p -> p.path("/oauth/**").uri("lb://shop-auth"))
                .route("shop-manage", p -> p.path("/admin/**").uri("lb://shop-manage"))
                .route("shop-seller", p -> p.path("/seller/**").and().readBody(String.class, s -> true).uri("lb://shop-seller").filter(loginFilter))
                .route("shop-user", p -> p.path("/user/app/**").and().readBody(String.class, s -> true).uri("lb://shop-user").filter(loginFilter)) // 此类请求是需要登陆验证的
                .route("shop-user", p -> p.path("/user/**").and().readBody(String.class, s -> true).uri("lb://shop-user"))

                .build();
    }
}
