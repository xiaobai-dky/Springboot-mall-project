package com.xiaobai.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

/**
 MapperScan注解指定当前项目的Mapper接口的路径,在项目启动时候自动加载所有mapper文件
 */
@MapperScan("com.xiaobai.store.mapper")
/**
 * @author xiaobaicai
 * data:2021-12-31
 */
@Configuration
@SpringBootApplication
public class StoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    @Bean
    public MultipartConfigElement getMultipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //设置相关信息
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
        factory.setMaxRequestSize(DataSize.of(15, DataUnit.MEGABYTES));
        //通过工厂类来创建 MultipartConfigElement 对象
        return factory.createMultipartConfig();
    }
}
