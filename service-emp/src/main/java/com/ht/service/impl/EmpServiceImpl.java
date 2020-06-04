package com.ht.service.impl;

import com.ht.bean.Emp;
import com.ht.dao.EmpDao;
import com.ht.service.IEmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/3/25.
 */
@Service
public class EmpServiceImpl implements IEmpService {
    @Resource
    private EmpDao empDao;
    @Override
    public List<Emp> selemp() {
        return empDao.allemp();
    }

    @Override
    public List<Map> seldepts() {
        return empDao.seldept();
    }

    @Override
    public Boolean addemp(Emp emp) {
       int i = empDao.addEmp(emp);
       if(i>0){//判断影响的行数
           return true;
       }
       return false;
    }

    @Override
    public Emp selemp(int id) {
        return empDao.selempbyid(id);
    }

    @Override
    public Boolean updemp(Emp emp) {
        int i = empDao.updemp(emp);
        if(i>0){//判断影响的行数
            return true;
        }
        return false;
    }

    @Override
    public Boolean delemp(int id) {
        int i = empDao.delemp(id);
        if(i>0){//判断影响的行数
            return true;
        }
        return false;
    }

    @Override
    public Emp login(Emp emp) {
        return empDao.login(emp);
    }
}
