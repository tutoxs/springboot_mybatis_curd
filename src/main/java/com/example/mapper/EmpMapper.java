package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//    删除员工
    @Delete("delete from tb_emp where id=#{id}")
    public int delete(Integer id);
//添加员工
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into tb_emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entryDate},#{deptId},#{createTime},#{updateTime});")
    public void insert(Emp emp);

//    更新员工
    @Update("update tb_emp set username = #{username},name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entryDate},dept_id=#{deptId},update_time=#{updateTime} where id= #{id}")
    public void update(Emp emp);

//    单条查询
//    开启驼峰映射
    @Select("select * from tb_emp where id=#{id}")
    public Emp getById(Integer id);

//    起别名，保持属性名一致
//@Select("select id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time createTime, update_time updateTime from tb_emp where id=#{id}")
//public Emp getById(Integer id);

//    Results手动映射封装
//    @Results({
//            @Result(column = "dept_id",property = "deptId"),
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime"),
//    })
//    @Select("select * from tb_emp where id=#{id}")
//    public Emp getById(Integer id);

//    条件查询
    @Select("select * from tb_emp where name like concat('%',#{name},'%') and gender=#{gender} and entrydate between #{start} and #{end};")
    public List<Emp> list(String name, short gender, LocalDate start,LocalDate end);

}
