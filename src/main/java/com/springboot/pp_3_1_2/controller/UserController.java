package com.springboot.pp_3_1_2.controller;

import com.springboot.pp_3_1_2.model.User;
import com.springboot.pp_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> lst = userService.getAllUsers();
        model.addAttribute("users", lst);
        return "users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long userId) {
        userService.deleteUserById(userId);
        return "redirect:users";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("id") Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user-info";
    }

}
