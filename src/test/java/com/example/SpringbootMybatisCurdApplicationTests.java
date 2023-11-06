package com.example;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class SpringbootMybatisCurdApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete() {
        int deleteNum = empMapper.delete(16);
        System.out.println(deleteNum);
    }

    @Test
    public void testInsert(){
        Emp emp=new Emp();
        emp.setUsername("tom");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntryDate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
    }

}
