package mapper;

import pojo.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> getAllEmp();

    Emp getEmpAndDept(Integer eid);

    Emp getEmpById(Integer id);

    void insert(Emp emp);
}
