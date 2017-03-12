package cc.cicadabear.domain.dto.user;


import cc.cicadabear.domain.dto.AbstractDto;
import cc.cicadabear.domain.entity.User;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Shengzhao Li
 */
public class UserUpdateDto extends AbstractDto {

    private String oldpwd;
    private String pwd;
    private String repwd;

    private String sspwd;
    private String method;


    public UserUpdateDto() {
    }

    public String getOldpwd() {
        return oldpwd;
    }

    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRepwd() {
        return repwd;
    }

    public void setRepwd(String repwd) {
        this.repwd = repwd;
    }

    public String getSspwd() {
        return sspwd;
    }

    public void setSspwd(String sspwd) {
        this.sspwd = sspwd;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

//    public void init(ServletRequest request) {
//        setUsername(request.getAttribute("user_name").toString());
//        setEmail(request.getAttribute("email").toString());
//        setMethod(request.getAttribute("method").toString());
//        setPasswd(request.getAttribute("passwd").toString());
//        setPass(request.getAttribute("pass").toString());
//        setIsAdmin(Integer.valueOf(request.getAttribute("is_admin").toString()));
//        setEnable(Integer.valueOf(request.getAttribute("enable").toString()));
//        setInviteNum(Integer.valueOf(request.getAttribute("invite_num").toString()));
//        setTransferEnable(Integer.valueOf(request.getAttribute("transfer_enable").toString()));
//        setTransferEnable(Integer.valueOf(request.getAttribute("transfer_enable").toString()));
//    }

}