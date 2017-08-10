package com.haipeng.interceptor;

import com.haipeng.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan(basePackageClasses = Application.class,useDefaultFilters = true)
public class MyAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyUserRequestInterceptor()).addPathPatterns("/user/**");
        registry.addInterceptor(new MyUserResponseInterceptor()).addPathPatterns("/148124/user/**");
        super.addInterceptors(registry);
    }
}
