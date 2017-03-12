package cc.cicadabear.service;

import cc.cicadabear.ContextTest;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Jack on 3/10/17.
 */
public class InviteCodeServiceTest extends ContextTest {

    @Autowired
    private InviteCodeService inviteCodeService;

    @Autowired
    private UserService userService;

    /**
     * 会员生成邀请码
     */
    @Test
    public void testGenerateCodes() {
        List<InviteCode> list = inviteCodeService.loadCodesByUser(1);
        User user = userService.loadUserByID(1);
        int inviteNum = user.getInviteNum();
        inviteCodeService.generateInviteCodes(user, 3);

        List<InviteCode> list2 = inviteCodeService.loadCodesByUser(1);

        Assert.assertEquals(list2.size(), list.size() + 3);
        Assert.assertEquals(user.getInviteNum(), inviteNum - 3);
    }

    /**
     * Admin生成邀请码
     */
    @Test
    public void testGenerateAdminCodes() {
        List<InviteCode> list = inviteCodeService.loadCodesByUser(1);
        List<InviteCode> list3 = inviteCodeService.loadCodesByUser(0);
        User user1 = userService.loadUserByID(1);
        inviteCodeService.generateAdminInviteCodes(user1, 10);

        List<InviteCode> list2 = inviteCodeService.loadCodesByUser(1);
        Assert.assertEquals(list2.size(), list.size() + 10);

        inviteCodeService.generateAdminInviteCodes(null, 10);

        List<InviteCode> list5 = inviteCodeService.loadCodesByUser(0);
        Assert.assertEquals(list5.size(), list3.size() + 10);
    }
}
