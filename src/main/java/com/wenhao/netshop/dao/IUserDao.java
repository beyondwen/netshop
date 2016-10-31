package com.wenhao.netshop.dao;

import com.wenhao.netshop.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lw on 2016/10/31.
 */
public interface IUserDao {

    public Boolean add(User user);

    public Boolean add(List<User> users);

    public void delete(Long id);

    public void update(User user);

    public User get(Long id);

    public List<User> getAll();
}
