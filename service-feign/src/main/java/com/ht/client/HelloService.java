package com.ht.client;

import com.ht.hystrix.HelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2020/4/7.
 */
//fallback 调用定义好的熔断器类，主要是发生错误时的界面处理
@FeignClient(value="service-hello",fallback = HelloServiceHystrix.class)
public interface HelloService {
    @RequestMapping(value="/hello")
    public String sayHello(@RequestParam(value="name")String uname);

}
