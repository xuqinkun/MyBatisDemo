package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Emp;

import java.util.List;

public interface DynamicConditionMapper {
    List<Emp> getEmpByCondition(Emp emp);

    int batchDelete(@Param("ids") Integer[] ids);

    Emp getEmpByColumns(@Param("id") Integer id);
}
