import mapper.DeptMapper;
import org.junit.Test;
import pojo.Dept;

import java.io.IOException;

public class DeptMapperTest {

    @Test
    public void testGetDept() throws IOException {
        DeptMapper mapper = SqlSessionUtils.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmps(1);
        System.out.println(dept.getEmps().size());
    }
}
