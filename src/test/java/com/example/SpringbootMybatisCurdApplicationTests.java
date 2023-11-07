package com.example;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCurdApplicationTests {
    @Autowired
    private EmpMapper empMapper;
//删除
    @Test
    public void testDelete() {
        int deleteNum = empMapper.delete(16);
        System.out.println(deleteNum);
    }
//添加
    @Test
    public void testInsert(){
        Emp emp=new Emp();
        emp.setUsername("tom2");
        emp.setName("汤姆2");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntryDate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
        System.out.println(emp.getId());
    }
//更新
    @Test
    public void testUpdate(){
        Emp emp=new Emp();
        emp.setId(10);
        emp.setUsername("tom10");
        emp.setName("汤姆10");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntryDate(LocalDate.of(2000,1,1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.update(emp);
    }
    @Test
    public void testUpdate2(){
        Emp emp=new Emp();
        emp.setId(10);
        emp.setUsername("tom1111");
        emp.setName("汤姆1111");
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.update2(emp);
    }

//    查询
    @Test
    public void testGetById(){
        Emp emp=empMapper.getById(8);
        System.out.println(emp);
    }
//   条件查询
    @Test
    public void testSelect(){
//        List<Emp> empList =empMapper.list("张",(short) 1,LocalDate.of(2010,10,10),LocalDate.of(2022,10,10));
        List<Emp> empList =empMapper.list(null,null,null,null);
        System.out.println(empList);
    }

    @Test
    public void  testDeleteAll(){
      List<Integer> ids=  Arrays.asList(1,2,3);
      empMapper.deleteAll(ids);
    }
}
