package cn.hsiangsun.client;

import cn.hsiangsun.client.fallback.UserClientFallBack;
import cn.hsiangsun.feign.FeignLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",fallback = UserClientFallBack.class,configuration = FeignLog.class)
public interface UserClient {

    //url = http://user-service/cloud/user/
    @GetMapping("/cloud/user/{id}")
    String findUserById(@PathVariable Integer id);

}
