package com.ht.client;

import com.ht.bean.Emp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/4/8.
 */
@FeignClient(value="service-emp")
public interface EmpService {

    @RequestMapping(value="/emplist")
    public List<Emp> allemp();

    @RequestMapping(value="/empadd") //@RequestBody
    public Boolean saveemp(Emp emp);

    @RequestMapping(value="/login")
    public Emp emplogin(Emp emp);

    @RequestMapping(value="/deptlist")
    public List<Map> deptlist();

    @RequestMapping(value="/toupd/{id}")
    public Emp toupd(@PathVariable("id") int id);

    @RequestMapping(value="/empupd")
    public Boolean upd(Emp emp);

    @RequestMapping(value="/empdel/{id}")
    public Boolean del(@PathVariable("id") int id);
}
