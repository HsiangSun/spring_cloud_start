package cn.hsiangsun.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLog {

    @Bean
    Logger.Level setFeignLogLevel(){
        return Logger.Level.FULL;  //设置feign的日志级别 full base head
    }

}
