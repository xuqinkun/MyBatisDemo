package mapper;

import pojo.Dept;
import pojo.Emp;

import java.util.List;

public interface DeptMapper {
    Dept getDept(Integer did);

    Dept getDeptAndEmps(Integer did);
}
