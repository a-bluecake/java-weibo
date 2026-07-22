package cn.culr.edu.weiboproject.mapper;

import cn.culr.edu.weiboproject.pojo.entity.Weibo;
import cn.culr.edu.weiboproject.pojo.vo.WeiboExpressVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeiboMapper {

    List<WeiboExpressVO> selectWeiboExpressVO();
    int insert(Weibo weibo);
    Weibo selectByWeiboId(Integer Id);
}


