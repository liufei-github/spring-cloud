package com.ht.web;

import com.ht.bean.Emp;
import com.ht.service.IEmpService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/4/3.
 */
@RestController
public class EmpServerController {
    @Value("${server.port}")
    String port;
    @Resource
    private IEmpService is;

    @RequestMapping("/emplist")
    public List<Emp> emplist(){
        System.out.println("这是 "+port+" 端口访问的！");
        List<Emp> list = is.selemp();
        return list;
    }

    @RequestMapping("/deptlist")
    public List<Map> deptlist(){
        return is.seldepts();
    }

    @RequestMapping("/empadd")
    public Boolean empadd(@RequestBody Emp emp){
        Boolean bln = is.addemp(emp);
        return bln;
    }

    @RequestMapping("/toupd/{id}")
    public Emp toupd(@PathVariable("id") int id){
        Emp emp = is.selemp(id);
        return emp;
    }

    @RequestMapping("/empupd")
    public Boolean empupd(@RequestBody Emp emp){
        Boolean bln = is.updemp(emp);
        return bln;
    }

    @RequestMapping("/empdel/{id}")
    public Boolean empdel(@PathVariable("id") int id){
        Boolean bln = is.delemp(id);
        return bln;
    }
    //登录
    @RequestMapping("/login")
    public Emp login(@RequestBody Emp emp){
        Emp emp1 = is.login(emp);
        return emp1;
    }
}
