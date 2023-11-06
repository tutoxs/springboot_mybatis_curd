package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {
    @Delete("delete from tb_emp where id=#{id}")
    public int delete(Integer id);

    @Insert("insert into tb_emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entryDate},#{deptId},#{createTime},#{updateTime});")
    public void insert(Emp emp);
}
