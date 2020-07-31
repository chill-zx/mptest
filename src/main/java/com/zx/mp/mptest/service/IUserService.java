package com.zx.mp.mptest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zx.mp.mptest.dao.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-22
 */
public interface IUserService extends IService<User> {
    //查询全部
    public Object getAll(int id);
    //条件查询
    public Object getOne(User user);
    //多条件查询
    public List<User> getList(User user);
    //新增
    public String insertUser(User user);
    //删除
    public String delete(Integer id);
}
