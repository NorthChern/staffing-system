package com.north.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.north.web.pojo.User;

public interface UserService extends IService<User> {

    /**
     * 保存或更新操作
     * @param user
     * @return true/false
     */
    boolean save(User user);

    /**
     * 分页及模糊查询查询
     * @param pageNum
     * @param pageSize
     * @param keyWord
     * @return
     */
    Page<User> findPage(Integer pageNum, Integer pageSize, String keyWord);

    //更新
    boolean update(User user);
}
