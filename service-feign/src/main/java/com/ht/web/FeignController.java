package com.ht.web;

import com.ht.bean.Emp;
import com.ht.client.EmpService;
import com.ht.client.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2020/4/7.
 */
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Value("${server.port}")
    String port;
    @Autowired
    private HelloService helloService;

    @Autowired
    private EmpService empService;

    @RequestMapping("/hello")
    public String hello(String name){

        String s =  helloService.sayHello(name);
        return s+" 服务消费者端口："+port;
    }

    @RequestMapping("/list")
    public String list(){
        List<Emp> list = empService.allemp();
        System.out.println("list size="+list.size());
        return "emplist";
    }

    @RequestMapping("/add")
    public String add(){
        Emp emp = new Emp();
        emp.seteName("Feign添加");
        emp.setPwd("123");
        emp.setAge(22);
        Boolean bln =  empService.saveemp(emp);
        return ""+bln;
    }
}
