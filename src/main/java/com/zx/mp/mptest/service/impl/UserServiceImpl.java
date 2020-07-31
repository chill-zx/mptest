package com.zx.mp.mptest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.mp.mptest.dao.entity.User;
import com.zx.mp.mptest.mapper.UserMapper;
import com.zx.mp.mptest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Object getAll(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public Object getOne(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("name",user.getName());
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public List<User> getList(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
        //.eq(StringUtils.isNotEmpty(user.getName()),"name", user.getName())
        .gt(user.getAge()!=null,"age",user.getAge())
        .like(StringUtils.isNotEmpty(user.getEmail()),"email",user.getEmail())
        .in(StringUtils.isNotEmpty(user.getName()),"name",StringUtils.isNotEmpty(user.getName())?user.getName().split(","):null)
        .orderByDesc("age");
        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }

    @Override
    public String insertUser(User user) {
        return userMapper.insert(user)>0?"success":"false";
    }

    @Override
    public String delete(Integer id) {
        return userMapper.deleteById(id)>0?"success":"false";
    }
}
