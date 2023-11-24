package com.springboot.pp_3_1_2.service;

import com.springboot.pp_3_1_2.model.User;
import com.springboot.pp_3_1_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public List<User> getAllUsers() {
       return userRepository.findAll();
    }



    public User getUserById(Long userId) {
       return userRepository.findById(userId).orElse(null);
    }

    @Transactional
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
