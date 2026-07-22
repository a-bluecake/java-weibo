package cn.culr.edu.weiboproject.pojo.vo;

import java.util.Date;

public class DetailsPageCommentVO {
    private String commentNickname;
    private String commentContent;
    private Date commentCreated;

    @Override
    public String toString() {
        return "DetailPageCommentVO{" +
                "commentNickname='" + commentNickname + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", commentCreated=" + commentCreated +
                '}';
    }

    public String getCommentNickname() {
        return commentNickname;
    }

    public void setCommentNickname(String commentNickname) {
        this.commentNickname = commentNickname;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentCreated() {
        return commentCreated;
    }

    public void setCommentCreated(Date commentCreated) {
        this.commentCreated = commentCreated;
    }
}
