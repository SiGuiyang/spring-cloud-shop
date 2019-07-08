package quick.pager.shop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quick.pager.shop.filter.LoginFilter;

@Configuration
public class FilterConfiguration {

    @Bean
    public LoginFilter sellerLoginFilter(){
        return new LoginFilter();
    }
}
