package cn.culr.edu.weiboproject.controller;

import cn.culr.edu.weiboproject.mapper.CommentMapper;
import cn.culr.edu.weiboproject.mapper.UserMapper;
import cn.culr.edu.weiboproject.pojo.entity.User;
import cn.culr.edu.weiboproject.pojo.entity.Weibo;
import cn.culr.edu.weiboproject.pojo.vo.DetailsPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class DetailsPageController {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/v1/users/detailspage")
    @ResponseBody
    public DetailsPageVO detailsPage(HttpServletRequest request){
        if(request.getSession().getAttribute("LOGIN_USER")==null){
            return null;
        }
        Weibo weibo = (Weibo) request.getSession().getAttribute("SELECT_WEIBO");

        if(weibo==null){
            return null;
        }

        DetailsPageVO detailsPageVO = new DetailsPageVO();

        detailsPageVO.setWeiboContent(weibo.getContent());
        detailsPageVO.setWeiboCreated(weibo.getCreated());
        User user = userMapper.selectByWeiboUserId(weibo.getUserId());

        detailsPageVO.setWeiboNickname(user.getNickname());
        detailsPageVO.setCommentList(commentMapper.selectByWeiboId(weibo.getId()));
        return detailsPageVO;
    }

}
/*
详情页
*/

