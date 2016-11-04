package com.wenhao.shiro.test.chapter3;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;

/**
 * Created by lw on 2016/11/1.
 */
public class BaseTest {

    @After
    public void tearDown() {
        ThreadContext.unbindSubject();
    }

    public void login(String conffile, String name, String password) {
        //首先拿到factory
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(conffile);
        //然后通过factory拿到securityManger
        SecurityManager securityManager = factory.getInstance();
        //设置securityManger
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            System.out.println("报错了"+e.getMessage());
        }
    }

    public Subject subject() {
        return SecurityUtils.getSubject();
    }
}
