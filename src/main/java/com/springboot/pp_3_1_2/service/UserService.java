package com.springboot.pp_3_1_2.service;



import com.springboot.pp_3_1_2.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    void deleteUserById(Long userId);
    void saveUser(User user);
}
