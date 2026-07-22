package cn.culr.edu.weiboproject.controller;

import cn.culr.edu.weiboproject.mapper.WeiboMapper;
import cn.culr.edu.weiboproject.pojo.entity.User;
import cn.culr.edu.weiboproject.pojo.entity.Weibo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class PublishWeiboController {
    @Autowired
    WeiboMapper weiboMapper;
    @RequestMapping("/v1/users/publishWeibo")
    @ResponseBody
    Integer publishWeibo(@RequestBody String content, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("LOGIN_USER");
        if(user==null){
            return 2;
        }
        Weibo weibo = new Weibo();
        weibo.setUserId(user.getId());
        weibo.setContent(content);
        weibo.setCreated(new Date());
        if(weiboMapper.insert(weibo)!=0){
            return 1;
        }
        return  0;
    }
}
