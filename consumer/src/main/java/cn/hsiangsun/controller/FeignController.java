package cn.hsiangsun.controller;

import cn.hsiangsun.client.UserClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private UserClient userClient;


    @GetMapping("/{id}")
    public String findUserById(@PathVariable Integer id){
        return userClient.findUserById(id);
    }

}
