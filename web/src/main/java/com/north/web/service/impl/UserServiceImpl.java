package com.north.web.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.north.web.mapper.UserMapper;
import com.north.web.pojo.User;
import com.north.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean save(User user) {
        int i = userMapper.insert(user);
        return i != 0;
    }

    @Override
    public Page<User> findPage(Integer pageNum, Integer pageSize, String keyWord) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if(StrUtil.isNotBlank(keyWord)){
            wrapper.like(User::getUserName, keyWord);
        }
        return userMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    }

    @Override
    public boolean update(User user) {
        int update = userMapper.updateById(user);
        if(update == 0){
            return false;
        }else {
            return true;
        }
    }
}
