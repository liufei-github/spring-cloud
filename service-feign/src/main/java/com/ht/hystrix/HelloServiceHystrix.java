package com.ht.hystrix;

import com.ht.client.HelloService;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2020/4/8.
 */
//(名词)controller /service /resposity一样，都是注入到spring容器的组件，为了方便分类才分开多种注解
    //（动词）resource @autowaired 自动装配
@Component
public class HelloServiceHystrix implements HelloService{

    @Override
    public String sayHello(String uname) {
        return "您好，"+uname+"，报错了，请刷新！";
    }
}
