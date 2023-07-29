package mapper;

import pojo.Emp;

import java.util.List;

public interface DynamicConditionMapper {
    List<Emp> getEmpByCondition(Emp emp);
}
