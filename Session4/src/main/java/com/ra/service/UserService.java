package com.ra.service;

import com.ra.model.entity.User;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public interface UserService {
    List<User> findAll();
    boolean checkExist(Predicate<User> predicate);
    User findUser(String key);
    User add(User user);
    User edit(User user);
    boolean remove(String id);
}
