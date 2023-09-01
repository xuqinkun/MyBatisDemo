import mapper.EmpMapper;
import org.junit.Test;
import pojo.Emp;

import java.io.IOException;
import java.util.List;

public class EmpMapperTest {

    @Test
    public void testGetAllEmp() throws IOException {
        EmpMapper empMapper = SqlSessionUtils.getMapper(EmpMapper.class);
        List<Emp> list = empMapper.getAllEmp();
        list.forEach(System.out::println);
    }

    @Test
    public void testEmpAndDept() throws IOException {
        EmpMapper empMapper = SqlSessionUtils.getMapper(EmpMapper.class);
        System.out.println(empMapper.getEmpAndDept(1));
    }

    @Test
    public void testEmpAndDeptById() throws IOException {
        EmpMapper empMapper = SqlSessionUtils.getMapper(EmpMapper.class);
        System.out.println(empMapper.getEmpById(1).getId());
    }

    @Test
    public void testInsert() throws IOException {
        EmpMapper empMapper = SqlSessionUtils.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEmail("aaa");
        empMapper.insert(emp);
    }
}
