package com.north.web.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("user")  //对应数据库表中的名字
@Data   //使用lombok
public class User {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private String userName;
    private String passwordHash;
    private Integer age;
    private String gender;
    private String email;
    private String phoneNumber;
    private String IDNumber;
    private Date joinDate;
    private Headshot headshot;

}
