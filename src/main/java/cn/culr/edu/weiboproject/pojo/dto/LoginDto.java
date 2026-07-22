package cn.culr.edu.weiboproject.pojo.dto;

public class LoginDto {
    private String username;
    private  String password;

    @Override
    public String toString() {
        return "DengLuDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
