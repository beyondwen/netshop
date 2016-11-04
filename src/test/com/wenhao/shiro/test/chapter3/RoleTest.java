package com.wenhao.shiro.test.chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lw on 2016/11/1.
 */
public class RoleTest extends BaseTest {

    @Test
    public void hasRole() {
        login("classpath:chapter3/shiro-role.ini", "zhang", "123");
        Assert.assertTrue(subject().hasRole("role1"));
        //判断拥有角色：role1 and role2
        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));
        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
    }
}
