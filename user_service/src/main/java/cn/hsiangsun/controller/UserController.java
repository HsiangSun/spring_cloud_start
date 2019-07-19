package cn.hsiangsun.controller;

import cn.hsiangsun.pojo.User;
import cn.hsiangsun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id){
        return userService.findUSerById(id);
    }

}
