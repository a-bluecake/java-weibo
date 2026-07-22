package cn.culr.edu.weiboproject.mapper;

import cn.culr.edu.weiboproject.pojo.entity.Comment;
import cn.culr.edu.weiboproject.pojo.vo.DetailsPageCommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int insert(Comment comment);
    List<DetailsPageCommentVO> selectByWeiboId(Integer weiboId);
}
