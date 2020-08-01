package com.zx.mp.mptest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zx.mp.mptest.dao.entity.User;
import com.zx.mp.mptest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class MptestApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setAge(18);
        user.setEmail("123@qq.com");
        user.setName("zxSy");
        //user.setVersion(1);
        userMapper.insert(user);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(1289610799534432258L);
        //user.setAge(12);
        userMapper.updateById(user);
    }
    /**
     * 批量查询
     */
    @Test
    public void selectList(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(2L, 1289610799534432258L, 1289629801975386113L));
        System.out.println(users);

    }


    /**
     * 测试 乐观锁插件
     */
    @Test
    public void testOptimisticLocker() {
        //查询
        User user = userMapper.selectById(1289610799534432258L);
        //修改数据
        user.setName("Helen Yao");
        user.setEmail("helen@qq.com");
        //执行更新
        userMapper.updateById(user);
    }

    @Test
    public void testPage(){
        /**参数，1：当前页 2：每页显示数*/
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
}
