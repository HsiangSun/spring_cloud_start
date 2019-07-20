package cn.hsiangsun.client.fallback;

import cn.hsiangsun.client.UserClient;
import org.springframework.stereotype.Component;

@Component //告诉IOC这是一个组件
public class UserClientFallBack implements UserClient {
    @Override
    public String findUserById(Integer id) {
        return "Something was wrong please try later :)";
    }
}
