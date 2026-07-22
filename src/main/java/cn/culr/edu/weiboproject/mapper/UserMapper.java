package cn.culr.edu.weiboproject.mapper;

import cn.culr.edu.weiboproject.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    User selectByUsername(String username);
    User selectByNickname(String nickname);
    int insert(User user);
    User selectByWeiboUserId(Integer userId);
}
