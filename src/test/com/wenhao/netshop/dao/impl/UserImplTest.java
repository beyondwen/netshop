package com.wenhao.netshop.dao.impl;

import com.wenhao.netshop.dao.IUserDao;
import com.wenhao.netshop.domain.User;
import com.wenhao.netshop.utils.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.SystemProfileValueSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by lw on 2016/10/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class UserImplTest {

    //RedisDao dao = new RedisDao("127.0.0.1", 6379);
    @Autowired
    private IUserDao dao;

    @Test
    public void add() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("wenhao");
        user.setPassword("1111");
        Boolean result = dao.add(user);
        System.out.println(result);
        user = dao.get(1L);
        System.out.println(user);
    }

}