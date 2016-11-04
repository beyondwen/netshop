package com.wenhao.shiro.test.chapter3;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lw on 2016/11/3.
 */
public class PermissionTest extends BaseTest {

    @Test
    public void isPermission() throws Exception {
        login("classpath:chapter3/shiro-permission.ini", "wen", "123");
        //对应shiro-permission.ini中第一种
        //subject().checkPermissions("system:user:update","system:user:view");
        //对应shiro-permission.ini中第二种
        //subject().checkPermissions("system:user:update,view");
        //role3 简写验证
        //subject().checkPermissions("system:user:create,delete,update,viewihhhhhhhhhhhhhhhhhhh");
        subject().checkPermissions("*:view");
    }
}
