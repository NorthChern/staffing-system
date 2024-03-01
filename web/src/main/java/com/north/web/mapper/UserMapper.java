package com.north.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.north.web.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
