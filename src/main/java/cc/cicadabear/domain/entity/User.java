package cc.cicadabear.domain.entity;

import cc.cicadabear.common.util.*;
import cc.cicadabear.domain.repository.UserRepository;
import cc.cicadabear.domain.shared.BeanProvider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author Shengzhao Li
 */
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@JsonIgnoreProperties({"user_repository", "username", "password",
        "last_get_gift_time", "last_rest_pass_time", "gravatar",
        "is_email_verify", "is_admin", "inviter_id",
        "invite_codes", "invitees"})
public class User extends AbstractEntity {


    private static final long serialVersionUID = -7873396364481790308L;

    private static final Logger LOG = LoggerFactory.getLogger(User.class);

    private transient UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

    @JsonProperty("user_repository")
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Column(name = "user_name")
    private String username;

    @Column(name = "email", unique = true)
    private String email;


    @Column(name = "pass")
    private String pass;

    @Column(name = "passwd")
    private String password;

    @Column(name = "t")
    private int t;

    @Column(name = "u", columnDefinition = "BIGINT(20)")
    private long u;

    @Column(name = "d", columnDefinition = "BIGINT(20)")
    private long d;

    @Column(name = "transfer_enable", columnDefinition = "BIGINT(20)")
    private long transferEnable;

    @Column(name = "port")
    private int port;

    @Column(name = "protocol")
    private String protocol = "origin";

    @Column(name = "obfs")
    private String obfs = "plain";

    @Column(name = "switch", columnDefinition = "tinyint(4)")
    private int switch_;

    @Column(name = "enable", columnDefinition = "tinyint(4)")
    private int enable;

    @Column(name = "type", columnDefinition = "tinyint(4)")
    private int type;

    @Column(name = "last_get_gift_time")
    private int lastGetGiftTime;

    @Column(name = "last_check_in_time")
    private int lastCheckInTime;

    @Column(name = "last_rest_pass_time")
    private int lastRestPassTime;

    @Column(name = "reg_date")
    private Date regDate;

    @Column(name = "invite_num")
    private int inviteNum;

    @Column(name = "is_admin")
    private int isAdmin;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_by", referencedColumnName = "id")
    private User inviter;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "inviter")
    private List<User> invitees;

    @Column(name = "expire_time")
    private int expireTime;

    @Column(name = "method")
    private String method = "rc4-md5";

    @Column(name = "is_email_verify")
    private int isEmailVerify;

    @Column(name = "reg_ip")
    private String regIp;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<InviteCode> inviteCodes;


    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public String email() {
        return email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{username='").append(username).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public User email(String email) {
        this.email = email;
        return this;
    }


    public User username(String username) {
        this.username = username;
        return this;
    }

    public String resetPassword() {
        String newOriginalPass = PasswordHandler.randomPassword();
        this.password = PasswordHandler.encryptPassword(newOriginalPass);
        LOG.debug("<{}> reset User [username={},guid={}] password", SecurityUtils.currentUsername(), username, id);
        return newOriginalPass;
    }


    public User deleteMe() {
//        this.archived(true);
        LOG.debug("<{}> delete User: {} [Logic delete]", SecurityUtils.currentUsername(), this);
        return this;
    }

    public User updatePassword(String newPassword) {
        this.password = PasswordHandler.encryptPassword(newPassword);
        LOG.debug("<{}> update user[{}] password", SecurityUtils.currentUsername(), this);
        return this;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("t")
    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    @JsonProperty("u")
    public long getU() {
        return u;
    }

    public void setU(long u) {
        this.u = u;
    }

    @JsonProperty("d")
    public long getD() {
        return d;
    }

    public void setD(long d) {
        this.d = d;
    }

    @JsonProperty("transfer_enable")
    public long getTransferEnable() {
        return transferEnable;
    }

    public void setTransferEnable(long transferEnable) {
        this.transferEnable = transferEnable;
    }

    @JsonProperty("port")
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonProperty("obfs")
    public String getObfs() {
        return obfs;
    }

    public void setObfs(String obfs) {
        this.obfs = obfs;
    }

    @JsonProperty("switch")
    public int getSwitch() {
        return switch_;
    }

    public void setSwitch_(boolean switch_) {

        this.switch_ = switch_ ? 1 : 0;
    }

    @JsonProperty("enable")
    public int getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable ? 1 : 0;
    }

    @JsonProperty("type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //    @JsonProperty("last_get_gift_time")
    @JsonIgnore
    public int getLastGetGiftTime() {
        return lastGetGiftTime;
    }

    public void setLastGetGiftTime(int lastGetGiftTime) {
        this.lastGetGiftTime = lastGetGiftTime;
    }

    @JsonProperty("last_check_in_time")
    public int getLastCheckInTime() {
        return lastCheckInTime;
    }

    public void setLastCheckInTime(int lastCheckInTime) {
        this.lastCheckInTime = lastCheckInTime;
    }

    //    @JsonProperty("last_rest_pass_time")
    @JsonIgnore
    public int getLastRestPassTime() {
        return lastRestPassTime;
    }

    public void setLastRestPassTime(int lastRestPassTime) {
        this.lastRestPassTime = lastRestPassTime;
    }

    @JsonIgnore
//    @JsonProperty("reg_date")
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @JsonProperty("invite_num")
    public int getInviteNum() {
        return inviteNum;
    }

    public void setInviteNum(int inviteNum) {
        this.inviteNum = inviteNum;
    }

    public boolean isAdmin() {
        return isAdmin == 1;
    }

    @JsonProperty("is_admin")
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin ? 1 : 0;
    }

    @JsonIgnore
    public User getInviter() {
        try {
            if (inviter.id() == 0) {
                return null;
            }
            return inviter;
        } catch (ObjectNotFoundException e) {
            return null;
        }
    }

    @JsonProperty("inviter_id")
    public int getInviterId() {
        User inviter = getInviter();
        if (inviter == null) {
            return 0;
        }
        return inviter.getId();
    }

    public void setInviter(User inviter) {
        this.inviter = inviter;
    }

    @JsonProperty("expire_time")
    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("is_email_verify")
    public int getIsEmailVerify() {
        return isEmailVerify;
    }

    @JsonIgnore
    public boolean isEmailVerify() {
        return isEmailVerify == 1;
    }

    public void setIsEmailVerify(boolean isEmailVerify) {
        this.isEmailVerify = isEmailVerify ? 1 : 0;
    }

    @JsonProperty("reg_ip")
    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    @JsonProperty("invite_codes")
    public List<InviteCode> getInviteCodes() {
        return inviteCodes;
    }

    public void setInviteCodes(List<InviteCode> inviteCodes) {
        this.inviteCodes = inviteCodes;
    }

    @JsonProperty("invitees")
    public List<User> getInvitees() {
        return invitees;
    }

    public void setInvitees(List<User> invitees) {
        this.invitees = invitees;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @JsonProperty("passwd")
    public String getPass() {
        return pass;
    }

    public double trafficUsagePercent() {
        long total = u + d;
        if (transferEnable == 0) {
            return 0;
        }
        double percent = total / transferEnable;
        percent = NumberUtils.round2(percent);
        percent = percent * 100;
        return percent;
    }

    public String enableTraffic() {
        return BandwidthUtils.flowAutoShow(transferEnable);
    }

    public long enableTrafficInGB() {
        return BandwidthUtils.flowToGB(transferEnable);
    }

    public String usedTraffic() {
        long total = u + d;
        return BandwidthUtils.flowAutoShow(total);
    }

    public String unusedTraffic() {
        long total = u + d;
        return BandwidthUtils.flowAutoShow(transferEnable - total);
    }

    public String lastSsTime() {
        if (t == 0) {
            return "从未使用喵";
        }
        return DateUtils.toDateTime(t);
    }

    public String lastCheckInTime() {
        if (lastCheckInTime == 0) {
            return "从未签到";
        }
        return DateUtils.toDateTime(lastCheckInTime);
    }

    @JsonProperty("gravatar")
    public String getGravatar() {
        return "https://secure.gravatar.com/avatar/daf81b9574e052950c3336edcbee64b4";
    }

    @JsonProperty("reg_date")
    public String getRegDateText() {
        return DateUtils.toDateTime(regDate);
    }


}