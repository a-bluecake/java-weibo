package cn.culr.edu.weiboproject.pojo.vo;

import java.util.Date;
import java.util.List;

public class DetailsPageVO {
    private Integer id;
    private String weiboNickname;
    private String weiboContent;
    private Date weiboCreated;
    List<DetailsPageCommentVO> commentList;

    @Override
    public String toString() {
        return "DetailsPageVO{" +
                "id=" + id +
                ", weiboNickname='" + weiboNickname + '\'' +
                ", weiboContent='" + weiboContent + '\'' +
                ", weiboCreated=" + weiboCreated +
                ", commentList=" + commentList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeiboNickname() {
        return weiboNickname;
    }

    public void setWeiboNickname(String weiboNickname) {
        this.weiboNickname = weiboNickname;
    }

    public String getWeiboContent() {
        return weiboContent;
    }

    public void setWeiboContent(String weiboContent) {
        this.weiboContent = weiboContent;
    }

    public Date getWeiboCreated() {
        return weiboCreated;
    }

    public void setWeiboCreated(Date weiboCreated) {
        this.weiboCreated = weiboCreated;
    }

    public List<DetailsPageCommentVO> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<DetailsPageCommentVO> commentList) {
        this.commentList = commentList;
    }
}
