package com.wenhao.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Created by lw on 2016/11/1.
 */
public class ShiroTest {

    @Test
    public void shiroTest() {
        //chapter1
        //Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //chapter2
        //Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:chapter2/shiro-realm.ini");
        //chapter2 shiro jdbc
        //Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:chapter2/shiro-jdbc.ini");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:chapter2/shiro-strategy.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        subject.logout();


    }
}
