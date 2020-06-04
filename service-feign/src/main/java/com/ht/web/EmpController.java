package com.ht.web;

import com.ht.bean.Emp;
import com.ht.client.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/4/9.
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(Emp emp, HttpSession session, Model model){
        Emp e = empService.emplogin(emp);
        if(e==null){//登录失败
            model.addAttribute("msg","账号或密码错误！");
            return "forward:tologin";
        }else{
            session.setAttribute("emp",e);
            return "redirect:list";
        }
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<Emp> list = empService.allemp();
        model.addAttribute("list",list);
        return "emplist";
    }

    @RequestMapping("/toadd")
    public String toadd(Model model){
        List<Map> deptlist= empService.deptlist();
        model.addAttribute("deptlist",deptlist);
        return "empadd";
    }

    @RequestMapping("/add")
    public String add(Emp emp){
        Boolean bln = empService.saveemp(emp);
        return "redirect:list";
    }

    @RequestMapping("/toupd")
    public String toupd(int id,Model model){
        Emp emp = empService.toupd(id);
        List<Map> deptlist= empService.deptlist();
        model.addAttribute("deptlist",deptlist);
        model.addAttribute("emp",emp);
        return "empupd";
    }
    @RequestMapping("/upd")
    public String upd(Emp emp){
        Boolean bln = empService.upd(emp);
        return "redirect:list";
    }

    @RequestMapping("/del")
    public  String del(int id){
        empService.del(id);
        return "redirect:list";
    }

}
