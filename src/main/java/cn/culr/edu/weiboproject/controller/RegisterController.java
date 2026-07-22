package cn.culr.edu.weiboproject.controller;

import cn.culr.edu.weiboproject.mapper.UserMapper;
import cn.culr.edu.weiboproject.pojo.dto.RegisterDto;
import cn.culr.edu.weiboproject.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class RegisterController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/v1/users/register")
    @ResponseBody
    Integer register(@RequestBody RegisterDto registerDto){
        User user = new User();
        if(userMapper.selectByUsername(registerDto.getUsername())!=null){
            return 2;
        }
        if(userMapper.selectByNickname(registerDto.getNickname())!=null){
            return 3;
        }
        else {
            user.setUsername(registerDto.getUsername());
            user.setPassword(registerDto.getPassword());
            user.setNickname(registerDto.getNickname());
            user.setCreated(new Date());
            if(userMapper.insert(user) != 0){
                return 1;
            }
            return 0;
        }
    }
}
