package cn.culr.edu.weiboproject.controller;

import cn.culr.edu.weiboproject.mapper.CommentMapper;
import cn.culr.edu.weiboproject.pojo.dto.PublishCommentDto;
import cn.culr.edu.weiboproject.pojo.entity.Comment;
import cn.culr.edu.weiboproject.pojo.entity.User;
import cn.culr.edu.weiboproject.pojo.entity.Weibo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class PublishCommentController {
    @Autowired
    CommentMapper commentMapper;
    @RequestMapping("/v1/users/publishComment")
    @ResponseBody
    Integer publishComment(@RequestBody PublishCommentDto publishCommentDto , HttpServletRequest request){
        Comment comment = new Comment();
        BeanUtils.copyProperties(publishCommentDto,comment);
        comment.setCreated(new Date());
        User user =(User) request.getSession().getAttribute("LOGIN_USER");
        if(user==null){
            return 2;
        }
        Weibo weibo = (Weibo) request.getSession().getAttribute("SELECT_WEIBO");
        if(weibo==null){
            return 3;
        }
        comment.setUserId(user.getId());
        comment.setWeiboId(weibo.getId());
        if(commentMapper.insert(comment)!=0){
            return 1;
        }
        return 0;
    }
}

