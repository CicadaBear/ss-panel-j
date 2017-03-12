package cc.cicadabear.domain.dto.user;


import cc.cicadabear.common.util.PasswordHandler;
import cc.cicadabear.domain.dto.AbstractDto;
import cc.cicadabear.domain.entity.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletRequest;

/**
 * @author Shengzhao Li
 */
public class AdminUserUpdateDto extends AbstractDto {

    private String username;
    private String password;
    private String pass;
    private String email;
    private String method;
    private int enable;
    private long transfer_enable;
    //    private int port;
    private int invite_num;

    private int is_admin;

    private User user;

    public AdminUserUpdateDto() {
    }

    public String getUsername() {
        return username;
    }

    public String getUser_name() {
        return username;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser_name(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswd() {
        return password;
    }

    public void setPasswd(String passwd) {
        this.password = passwd;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return StringUtils.lowerCase(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public long getTransferEnable() {
        return transfer_enable;
    }

    public long getTransfer_enable() {
        return transfer_enable;
    }

    public void setTransfer_enable(long transfer_enable) {
        this.transfer_enable = transfer_enable;
    }

    public void setTransferEnable(long transfer_enable) {
        this.transfer_enable = transfer_enable;
    }

    public int getInviteNum() {
        return invite_num;
    }

    public int getInvite_num() {
        return invite_num;
    }

    public void setInvite_num(int invite_num) {
        this.invite_num = invite_num;
    }

    public void setInviteNum(int invite_num) {
        this.invite_num = invite_num;
    }

    public boolean isAdmin() {
        return is_admin == 0;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    public void setIsAdmin(int is_admin) {
        this.is_admin = is_admin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}