package cn.culr.edu.weiboproject.controller;

import cn.culr.edu.weiboproject.mapper.UserMapper;
import cn.culr.edu.weiboproject.pojo.dto.LoginDto;
import cn.culr.edu.weiboproject.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    UserMapper  userMapper;
    @RequestMapping("/v1/users/login")
    @ResponseBody
    Integer login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        User user = userMapper.selectByUsername(loginDto.getUsername());
        if(user==null){
            return 3;
        }
        else if(!Objects.equals(user.getPassword(), loginDto.getPassword())){
            return 2;
        }else if(Objects.equals(user.getPassword(), loginDto.getPassword())){
            request.getSession().setAttribute("LOGIN_USER",user);
            return 1;
        }
        return 0;
    }
}
