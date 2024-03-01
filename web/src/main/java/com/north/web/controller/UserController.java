package com.north.web.controller;

import com.north.web.config.Result;
import com.north.web.pojo.User;
import com.north.web.service.UserService;
import com.north.web.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.hibernate.query.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "UserService")
    private UserService userService;

    //@RequestBody:将前端json对象映射到User对象
    //新增
    @PostMapping
    public Result<?> save(@RequestBody User user){
        boolean save = userService.save(user);
        if (save){
            return Result.success();
        }else {
            return Result.error("1","保存失败");
        }
    }

    //更新
    @PutMapping
    public Result<?> update(@RequestBody User user){
        boolean flag = userService.update(user);
        if(flag){
            return Result.success();
        }else{
            return Result.error("1","更新失败");
        }
    }

    //查询
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String keyWord){
        return Result.success(userService.findPage(pageNum,pageSize,keyWord));
    }
}
