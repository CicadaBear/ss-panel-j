package cc.cicadabear.domain.dto.user;


import cc.cicadabear.common.util.PasswordHandler;
import cc.cicadabear.domain.dto.AbstractDto;
import cc.cicadabear.domain.entity.User;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Shengzhao Li
 */
public class UserRegisterDto extends AbstractDto {

    private String username;
    private String password;
    private String rePassword;
    private String email;
    private String code;

    public UserRegisterDto() {
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

    public void setPasswd(String passwd) {
        this.password = passwd;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public void setRePasswd(String rePasswd) {
        this.rePassword = rePasswd;
    }


    public String getEmail() {
        return StringUtils.lowerCase(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public User toEntity() {
        String encryptPass = PasswordHandler.encryptPassword(password);
        User user = new User(username, encryptPass, email);
        return user;
    }

}