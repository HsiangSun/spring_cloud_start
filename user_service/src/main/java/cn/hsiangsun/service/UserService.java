package cn.hsiangsun.service;

import cn.hsiangsun.mapper.UserMapper;
import cn.hsiangsun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUSerById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

}
