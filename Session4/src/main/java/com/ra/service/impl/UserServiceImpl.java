package com.ra.service.impl;

import com.ra.model.entity.User;
import com.ra.repository.Repository;
import com.ra.repository.impl.RepositoryImpl;
import com.ra.service.UserService;
import com.ra.util.annotation.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
@Service
public class UserServiceImpl implements UserService {
    private Repository<User> userRepository;

    public UserServiceImpl() {
        this.userRepository = new RepositoryImpl<>();
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll(User.class);
    }

    @Override
    public boolean checkExist(Predicate<User> predicate) {
        return false;
    }

    @Override
    public User findUser(String key) {
        return userRepository.findId(User.class, key);
    }

    @Override
    public User add(User user) {
        return userRepository.add(user);
    }

    @Override
    public User edit(User user) {
        return userRepository.edit(user);
    }

    @Override
    public boolean remove(String id) {
        return userRepository.remove(User.class, id);
    }
}
