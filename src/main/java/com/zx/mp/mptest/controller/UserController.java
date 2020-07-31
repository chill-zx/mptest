package com.zx.mp.mptest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.mp.mptest.dao.entity.User;
import com.zx.mp.mptest.mapper.UserMapper;
import com.zx.mp.mptest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-22
 */
@RestController
@RequestMapping("/user/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("getAll/{id}")
    //查询所有
    public Object getAll(@PathVariable int id){
        return userService.getAll(id);
    }

    //条件查询
    @GetMapping("getOne")
    public Object getOne(User user){
        return userService.getOne(user);
    }
    //精准条件多查询
    @GetMapping("getList")
    public List<User> getList(User user){
        return userService.getList(user);
    }
    //新增
    @GetMapping("insert")
    public String insertUser(User user){
        return userService.insertUser(user);
    }
    @GetMapping("delete")
    public String delete(Integer id){
        return userService.delete(id);
    }
}
