package com.ht.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2020/4/8.
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(1000,3000,3);
    }

    @Bean
    public Logger.Level loggerlevel(){
        return Logger.Level.FULL;
    }
}
