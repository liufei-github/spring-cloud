package com.ht.dao;

import com.ht.bean.Emp;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/3/25.
 */
@Repository
@Transactional
public interface EmpDao {
    List<Emp> allemp();
    List<Map> seldept();
    int addEmp(Emp emp);
    Emp selempbyid(int id);
    int updemp(Emp emp);
    int delemp(int id);

    Emp login(Emp emp);
}
