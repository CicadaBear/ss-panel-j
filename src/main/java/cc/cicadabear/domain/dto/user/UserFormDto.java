package cc.cicadabear.domain.dto.user;


import cc.cicadabear.common.util.PasswordHandler;
import cc.cicadabear.domain.entity.User;

/**
 * @author Shengzhao Li
 */
public class UserFormDto extends UserDto {
    private String password;
    private String rePassword;

    private String existUsername;

    public UserFormDto() {
    }

    public UserFormDto(User user) {
        super(user);
        this.existUsername = user.username();
    }

    @Override
    public boolean isNewly() {
        return super.isNewly() || id == 0;
    }

//    public List<Privilege> getAllPrivileges() {
//        return Privilege.authPrivileges();
//    }


    public User toEntity() {
        String encryptPass = PasswordHandler.encryptPassword(password);
        return new User(username, encryptPass, email);
    }


    public String getPassword() {
        return password;
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

    public String getExistUsername() {
        return existUsername;
    }

    public void setExistUsername(String existUsername) {
        this.existUsername = existUsername;
    }
}