package com.ht.web;

import com.ht.bean.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/4/3.
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/list")
    public String list(Model model){
        Emp[] empArray = restTemplate.getForObject("http://service-emp/emplist", Emp[].class);
        List<Emp> list = Arrays.asList(empArray);
        model.addAttribute("list",list);
        return "emplist";
    }

    //去添加
    @RequestMapping("/toadd")
    public String toadd(Model model){
        Map[] deptArray = restTemplate.getForObject("http://service-emp/deptlist",Map[].class);
        List<Map> deptlist = Arrays.asList(deptArray);
        model.addAttribute("deptlist",deptlist);
        return "empadd";
    }

    @RequestMapping("/add")
    public String add(Emp emp){
        ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity("http://service-emp/empadd",emp,Boolean.class);
        Boolean aBoolean = responseEntity.getBody();
        if(aBoolean){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
        return "redirect:list";
    }

    @RequestMapping("/toupd")
    public String toupd(int id,Model model){
        Map params = new HashMap();
        params.put("id",id);
       ResponseEntity<Emp> empResponseEntity =  restTemplate.getForEntity("http://service-emp/toupd/{id}",Emp.class,params);
        Emp emp = empResponseEntity.getBody();

        Map[] deptArray = restTemplate.getForObject("http://service-emp/deptlist",Map[].class);
        List<Map> deptlist = Arrays.asList(deptArray);

        model.addAttribute("deptlist",deptlist);
        model.addAttribute("emp",emp);
        return "empupd";
    }

    @RequestMapping("/upd")
    public String upd(Emp emp){
        ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity("http://service-emp/empupd",emp,Boolean.class);
        Boolean aBoolean = responseEntity.getBody();
        if(aBoolean){
            System.out.println("修该成功");
        }else{
            System.out.println("修改失败");
        }
        return "redirect:list";
    }

    @RequestMapping("/del")
    public String del(int id){
        Map params = new HashMap();
        params.put("id",id);
        boolean bln=  restTemplate.getForObject("http://service-emp/empdel/{id}",Boolean.class,params);
        if(bln){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        return "redirect:list";
    }
}
