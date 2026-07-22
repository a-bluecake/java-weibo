package cn.culr.edu.weiboproject.pojo.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Weibo {
    private Integer id;
    private String content;
    private Date created;
    private Integer userId;

    @Override
    public String toString() {
        return "weibo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", userId=" + userId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}