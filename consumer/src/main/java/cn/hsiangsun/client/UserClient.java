package cn.hsiangsun.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserClient {

    //url = http://user-service/cloud/user/
    @GetMapping("/cloud/user/{id}")
    String findUserById(@PathVariable Integer id);

}
