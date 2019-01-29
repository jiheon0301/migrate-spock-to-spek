package io.honeymon.training.mtfss.domain.entity;

/**
 * @author jiheon.kim on 2019-01-08
 */
public class User {
    private Long id;
    private String username;
    private String nickName;

    protected User() {
    }

    public static User of(String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
