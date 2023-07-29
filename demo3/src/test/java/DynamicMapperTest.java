import mapper.DynamicConditionMapper;
import org.junit.Test;
import pojo.Emp;

import java.io.IOException;
import java.util.List;

public class DynamicMapperTest {
    @Test
    public void getEmpByConditionTest() throws IOException {
        DynamicConditionMapper mapper = SqlSessionUtils.getMapper(DynamicConditionMapper.class);
        List<Emp> emps = mapper.getEmpByCondition(new Emp(null, null, 0, null, ""));
        emps.forEach(System.out::println);
    }
}
