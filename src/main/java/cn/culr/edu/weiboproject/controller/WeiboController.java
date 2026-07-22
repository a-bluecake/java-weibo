package cn.culr.edu.weiboproject.controller;

import cn.culr.edu.weiboproject.mapper.WeiboMapper;
import cn.culr.edu.weiboproject.pojo.dto.WeiboDto;
import cn.culr.edu.weiboproject.pojo.entity.User;
import cn.culr.edu.weiboproject.pojo.entity.Weibo;
import cn.culr.edu.weiboproject.pojo.vo.WeiboExpressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WeiboController {
    @Autowired
    WeiboMapper weiboMapper;
    @RequestMapping("/v1/users/expressallweibo")
    @ResponseBody
    List<WeiboExpressVO> weibo(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("LOGIN_USER");
        if(user==null){
            return null;
        }
        List<WeiboExpressVO> weiboExpressVOS= weiboMapper.selectWeiboExpressVO();
        return weiboExpressVOS;
    }
    @RequestMapping("/v1/users/expressdetailsWeibo")
    @ResponseBody
    Integer detailsWeibo(@RequestBody WeiboDto weiboDto, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("LOGIN_USER");
        if(user==null){
            return 2;
        }
        if(weiboDto!=null){
            Weibo weibo = weiboMapper.selectByWeiboId(weiboDto.getId());
            request.getSession().setAttribute("SELECT_WEIBO",weibo);
            return 1;
        }
        return 0;
    }
    @RequestMapping("/v1/users/notlogin")
    @ResponseBody
    Integer notLogin(HttpServletRequest  request){
        request.getSession().setAttribute("LOGIN_USER",null);
        return 1;
    }
}
