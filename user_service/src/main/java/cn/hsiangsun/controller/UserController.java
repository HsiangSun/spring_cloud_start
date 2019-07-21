package cn.hsiangsun.controller;

import cn.hsiangsun.pojo.User;
import cn.hsiangsun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RefreshScope //从远程刷新配置文件
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${test.name}")
    private String name;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id){
        System.out.println("This value from remote config and timely refresh -->"+name);
        return userService.findUSerById(id);
    }

}
