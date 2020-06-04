package com.ht.web;

import com.ht.bean.Emp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/3/31.
 */
//此注解类的所有方法默认都返回json格式数据(不需要加ResponseBody注解)
@RestController
public class HelloController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello(String name){
        return "hello,"+name+",这是从端口"+port+"访问的！";
    }

    @RequestMapping("/addemp")
    public Boolean addemp(@RequestBody Emp emp){
        System.out.println(emp.toString());
        System.out.println("保存到数据库");
        System.out.println("你好，李老师！");
        return true;
    }
}
