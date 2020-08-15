package com.yanfzh.config;

import com.yanfzh.component.LoginHandlerInterceptor;
import com.yanfzh.component.MylocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @program: spring-boot-webapp
 * @description:
 * @author: Yanfzh
 * @create: 2020-08-10 11:52
 **/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/yanfzh").setViewName("success");
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/index.html").setViewName("login");
    }

    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer config = new WebMvcConfigurer() {
            //注册拦截器, "/**"表示任意请求，excludePathPatterns表示除它之外的请求
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");


            }
        };
        return config;
    }

    @Bean("localeResolver")
    public LocaleResolver localeResolver(){
        return new MylocaleResolver();
    }

}
