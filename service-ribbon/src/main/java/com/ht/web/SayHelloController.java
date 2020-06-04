package com.ht.web;

import com.ht.bean.Emp;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2020/4/2.
 */
@RestController
public class SayHelloController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(String name){
        String ss = restTemplate.getForObject("http://SERVICE-HELLO/hello?name="+name,String.class);
        return ss;
    }

    public String hiError(String name){
        return "hi,"+name+",error!";
    }

    @RequestMapping("/add")
    public String add(){
        Emp emp = new Emp();
        emp.seteName("张三");
        emp.setPwd("123");

        ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity("http://service-hello/addemp",emp,Boolean.class);
        Boolean aBoolean = responseEntity.getBody();
        System.out.println("保存结果："+aBoolean);
        return aBoolean.toString();
    }

}
