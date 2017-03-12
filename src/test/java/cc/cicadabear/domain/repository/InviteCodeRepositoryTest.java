package cc.cicadabear.domain.repository;

import cc.cicadabear.ContextTest;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.service.InviteCodeService;
import cc.cicadabear.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Jack on 3/10/17.
 */
public class InviteCodeRepositoryTest extends ContextTest {

    @Autowired
    private InviteCodeRepository inviteCodeRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testSaveAdminInviteCode() {
//        ThreadLocalHolder.getSession().getTransaction().begin();
        int num = 10;
        List<InviteCode> list = inviteCodeRepository.findByUser(0);
        for (int i = 0; i < num; i++) {
            InviteCode inviteCode = new InviteCode(RandomStringUtils.randomAlphanumeric(32));
            inviteCode.setCreator(null);
            inviteCodeRepository.insert(inviteCode);
            System.out.println("========="+inviteCode.getId());
        }
        List<InviteCode> list2 = inviteCodeRepository.findByUser(0);
        Assert.assertEquals(list2.size(), list.size() + 10);

        User user = userService.loadUserByID(1);
        List<InviteCode> list3 = user.getInviteCodes();
        for (int i = 0; i < num; i++) {
            InviteCode inviteCode = new InviteCode(RandomStringUtils.randomAlphanumeric(32));
            inviteCode.setCreator(user);
            inviteCodeRepository.insert(inviteCode);
            System.out.println("========="+inviteCode.getId());
        }
//        ThreadLocalHolder.getSession().clear();
//        ThreadLocalHolder.getSession().getTransaction().commit();
//        List<InviteCode> list4 = inviteCodeRepository.findByUser(1);
//        System.out.println(list4.hashCode());
//        System.out.println(list3.hashCode());
//        Assert.assertNotEquals(list4, list3);
//        Assert.assertEquals(list4.size(), list3.size() + 10);

    }
}
