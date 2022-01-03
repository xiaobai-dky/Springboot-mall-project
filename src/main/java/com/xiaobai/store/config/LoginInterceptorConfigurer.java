package com.xiaobai.store.config;

import com.xiaobai.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器拦截器的注册
 * @author PC
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    /**
     * 配置拦截器
     * @param registry 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 创建自定义的拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();
        // 配置白名单
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/districts/**");
        patterns.add("/products/**");

        //完成拦截器的注册 /**表示项目下所有的url都被拦截
        registry.addInterceptor(interceptor).
                addPathPatterns("/**").
                excludePathPatterns(patterns);
    }
}
