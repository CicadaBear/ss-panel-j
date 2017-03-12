package cc.cicadabear.domain.repository;

import cc.cicadabear.ContextTest;
import cc.cicadabear.common.config.JConfig;
import cc.cicadabear.common.util.BandwidthUtils;
import cc.cicadabear.common.util.DateUtils;
import cc.cicadabear.common.util.PasswordHandler;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * Created by Jack on 3/10/17.
 */
public class UserRepositoryTest extends ContextTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * one-to-one parent 为 0 null 测试
     */
    @Test
    public void testSaveUserWithAdminCreateCommand() {
        User user = new User();
        user.setUsername("test");
        user.email("test@cicadabear.cc");
        user.setPassword(PasswordHandler.encryptPassword("123456"));
//        InviteCode inviteCode = inviteCodeService.loadCodeByNo(registerDto.getCode());
//        InviteCode inviteCode = new InviteCode();
//        inviteCode.setCreator(null);
        User user2 = userRepository.findById(1, User.class);
//        user.id(0);
        user.setInviter(user2);
        user.setPort(userRepository.findLastPort() + 1);
        user.setEnable(true);
        user.setIsAdmin(false);
        user.setPass(RandomStringUtils.randomAlphanumeric(6));
        user.setTransferEnable(BandwidthUtils.toGB(JConfig.getInteger("defaultTraffic")));
        user.setInviteNum(JConfig.getInteger("inviteNum"));
        user.setRegIp(ThreadLocalHolder.clientIp());
        user.setRegDate(DateUtils.now());
        userRepository.saveOrUpdate(user);
    }

    /**
     * save user 级联 inviteCode list 测试
     */
    @Test
    public void testSaveUserWithListOfInviteCode() {

    }

}
