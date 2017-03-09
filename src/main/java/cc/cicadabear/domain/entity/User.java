package cc.cicadabear.domain.entity;

import cc.cicadabear.common.util.*;
import cc.cicadabear.domain.repository.UserRepository;
import cc.cicadabear.domain.shared.BeanProvider;
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
public class User extends AbstractEntity {


    private static final long serialVersionUID = -7873396364481790308L;

    private static final Logger LOG = LoggerFactory.getLogger(User.class);

    private transient UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

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
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
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

    public static Logger getLOG() {
        return LOG;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public long getU() {
        return u;
    }

    public void setU(long u) {
        this.u = u;
    }

    public long getD() {
        return d;
    }

    public void setD(long d) {
        this.d = d;
    }

    public long getTransferEnable() {
        return transferEnable;
    }

    public void setTransferEnable(long transferEnable) {
        this.transferEnable = transferEnable;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getObfs() {
        return obfs;
    }

    public void setObfs(String obfs) {
        this.obfs = obfs;
    }

    public int getSwitch() {
        return switch_;
    }

    public void setSwitch_(boolean switch_) {

        this.switch_ = switch_ ? 1 : 0;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable ? 1 : 0;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLastGetGiftTime() {
        return lastGetGiftTime;
    }

    public void setLastGetGiftTime(int lastGetGiftTime) {
        this.lastGetGiftTime = lastGetGiftTime;
    }

    public int getLastCheckInTime() {
        return lastCheckInTime;
    }

    public void setLastCheckInTime(int lastCheckInTime) {
        this.lastCheckInTime = lastCheckInTime;
    }

    public int getLastRestPassTime() {
        return lastRestPassTime;
    }

    public void setLastRestPassTime(int lastRestPassTime) {
        this.lastRestPassTime = lastRestPassTime;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getInviteNum() {
        return inviteNum;
    }

    public void setInviteNum(int inviteNum) {
        this.inviteNum = inviteNum;
    }

    public boolean isAdmin() {
        return isAdmin == 1;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin ? 1 : 0;
    }

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

    public void setInviter(User inviter) {
        this.inviter = inviter;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getIsEmailVerify() {
        return isEmailVerify;
    }

    public boolean isEmailVerify() {
        return isEmailVerify == 1;
    }

    public void setIsEmailVerify(boolean isEmailVerify) {
        this.isEmailVerify = isEmailVerify ? 1 : 0;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }


    public List<InviteCode> getInviteCodes() {
        return inviteCodes;
    }

    public void setInviteCodes(List<InviteCode> inviteCodes) {
        this.inviteCodes = inviteCodes;
    }

    public List<User> getInvitees() {
        return invitees;
    }

    public void setInvitees(List<User> invitees) {
        this.invitees = invitees;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

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

    public String getGravatar() {
        return "https://secure.gravatar.com/avatar/daf81b9574e052950c3336edcbee64b4";
    }

    public String getRegDateText() {
        return DateUtils.toDateTime(regDate);
    }


}