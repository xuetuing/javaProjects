package com.huawei.springbootdemo.mapper;

import com.huawei.springbootdemo.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UserMapper {

    @Insert(value = "insert into user (name, createtime) values (#{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})")
    int insert(User user);

    @Select(value = "select id, name, createtime from user where id = #{id,jdbcType=INTEGER}")
    @Results(value = { @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
    User selectByPrimaryKey(Integer id);

}
