package cc.cicadabear.service;

import cc.cicadabear.ContextTest;
import cc.cicadabear.domain.dto.user.UserRegisterDto;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Jack on 3/10/17.
 */
public class UserServiceTest extends ContextTest {

    @Autowired
    private UserService userService;

    @Autowired
    private InviteCodeService inviteCodeService;

    @Autowired
    private UserRepository userRepository;

    /**
     * 用户注册
     */
    @Test
    public void testRegisterUser() {
        UserRegisterDto dto = new UserRegisterDto();
        List<InviteCode> inviteCodes = inviteCodeService.loadCodesByUser(1);
        int count = userService.loadCount();
        int port = userRepository.findLastPort();
        dto.setCode(inviteCodes.get(0).getCode());
        dto.setUsername("Jack Lee");
        dto.setEmail("123@123.com");
        dto.setPasswd("123456");
        userService.registerUser(dto);
        System.out.println(dto.toEntity());
        List<InviteCode> inviteCodes2 = inviteCodeService.loadCodesByUser(1);

        Assert.assertEquals(userService.loadCount(), count + 1);
        Assert.assertEquals(inviteCodes2.size(), inviteCodes.size() - 1);
        Assert.assertEquals(dto.toEntity().getPort(), port + 1);
    }
}
