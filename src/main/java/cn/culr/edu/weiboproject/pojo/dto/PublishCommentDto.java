package cn.culr.edu.weiboproject.pojo.dto;

public class PublishCommentDto{
    private String content;

    @Override
    public String toString() {
        return "PublishCommentDto{" +
                "content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
