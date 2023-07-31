package mapper;

import org.junit.Test;
import pojo.Emp;
import pojo.EmpExample;
import utils.SqlSessionUtils;

import java.io.IOException;
import java.util.List;

public class EmpTest {
    @Test
    public void testSelect() throws IOException {
        EmpMapper mapper = SqlSessionUtils.getMapper(EmpMapper.class);
//        List<Emp> emps = mapper.selectByExample(null);
        EmpExample example = new EmpExample();
        example.createCriteria().andAgeEqualTo(23);
        example.or().andSexEqualTo("M");
        List<Emp> emps = mapper.selectByExample(example);
        emps.forEach(System.out::println);
    }
}
