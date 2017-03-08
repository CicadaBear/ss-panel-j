package cc.cicadabear.domain.dto.user;


import cc.cicadabear.common.util.PasswordHandler;
import cc.cicadabear.domain.entity.User;

/**
 * @author Shengzhao Li
 */
public class UserLoginDto extends UserDto {

    private String email;

    private String passwd;

    private String rememberMe;

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    public void setRemember_me(String rememberMe) {
        this.rememberMe = rememberMe;
    }
}