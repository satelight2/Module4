package com.ra.web.service.impl;

import com.ra.web.model.entity.User;
import com.ra.web.repository.Repository;
import com.ra.web.repository.impl.RepositoryImpl;
import com.ra.web.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        return userRepository.findAll(User.class).stream()
                .anyMatch(predicate);
    }

    @Override
    public User findSingle(Predicate<User> predicate) {
        return userRepository.findAll(User.class).stream()
                .filter(predicate).findFirst().orElse(null);
    }

    @Override
    public List<User> findBy(Predicate<User> predicate) {
        return userRepository.findAll(User.class).stream()
                .filter(predicate).collect(Collectors.toList());
    }

    @Override
    public User findId(String id) {
        return userRepository.findId(User.class, id);
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
