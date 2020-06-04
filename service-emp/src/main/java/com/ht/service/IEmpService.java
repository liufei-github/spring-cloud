package com.ht.service;

import com.ht.bean.Emp;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/3/25.
 */
public interface IEmpService {
    public List<Emp> selemp();

    public List<Map> seldepts();

    public Boolean addemp(Emp emp);

    public Emp selemp(int id);

    public Boolean updemp(Emp emp);

    public Boolean delemp(int id);

    public Emp login(Emp emp);
}
