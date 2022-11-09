package com.example.preproject312.service;

import com.example.preproject312.model.User;
import com.example.preproject312.repository.UserRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Transactional
    @Override
    public void update(long id, User newUser) {
        User oldUser = userRepository.getReferenceById(id);
        oldUser.setName(newUser.getName());
        oldUser.setAge(newUser.getAge());
        oldUser.setEmail(newUser.getEmail());
    }

    @Override
    public List<User> back() {
        return userRepository.findAll();
    }

    @Override
    public User backByID(@Param("id") Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
