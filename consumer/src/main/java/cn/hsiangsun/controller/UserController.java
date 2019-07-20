package cn.hsiangsun.controller;


import cn.hsiangsun.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "defaultFailCall") //默认出错的处理方法(加在该类上)
@EnableFeignClients //开启feign
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient; //注意包名org.springframework.cloud.client.discovery

    @GetMapping("/{id}")
    //@HystrixCommand(fallbackMethod = "failCallBack") //当方法执行失败时的降级处理(调用出错方法)
//    @HystrixCommand
    public String findUserById(@PathVariable Integer id){
//        List<ServiceInstance> user_serviceList = discoveryClient.getInstances("user_service");
//        ServiceInstance serviceInstance = user_serviceList.get(0);
//        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/cloud/user/"+id;

        String url = "http://user-service/cloud/user/"+id;

        return restTemplate.getForObject(url,String.class);
    }

    //单个方法出错的容错处理
    public String failCallBack(Integer id){
        log.error("fail to find user info when id = {}",id);
        return "Sorry something was wrong, please try later :)";
    }

    public String defaultFailCall(){
        log.error("This info from default error");
        return "The current network was not good,please try after";
    }
}
