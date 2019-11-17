package com.huawei.springbootdemo.mapper;

import com.huawei.springbootdemo.bean.UserLog;
import com.huawei.springbootdemo.bean.UserLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserLogMapper {

    int countByExample(UserLogExample example);

    int deleteByExample(UserLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserLog record);

    int insertSelective(UserLog record);

    List<UserLog> selectByExample(UserLogExample example);

    UserLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByExample(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByPrimaryKeySelective(UserLog record);

    int updateByPrimaryKey(UserLog record);
}
