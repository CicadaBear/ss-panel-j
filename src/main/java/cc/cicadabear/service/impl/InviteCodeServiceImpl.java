package cc.cicadabear.service.impl;

import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.domain.repository.InviteCodeRepository;
import cc.cicadabear.domain.repository.UserRepository;
import cc.cicadabear.service.InviteCodeService;
import cc.cicadabear.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 */
@Service("inviteCodeService")
public class InviteCodeServiceImpl implements InviteCodeService {

    @Autowired
    private InviteCodeRepository inviteCodeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public InviteCode loadCodeByNo(String code) {
        return inviteCodeRepository.findByNo(code);
    }

    @Override
    public boolean isExistByNo(String code) {
        return loadCodeByNo(code) != null;
    }

    @Override
    public List<InviteCode> loadCodesByUser(int userId) {
        List<InviteCode> list = inviteCodeRepository.findByUser(userId);
        return list;
    }

    @Override
    public void generateInviteCodes(User user, int num) {
        for (int i = 0; i < num; i++) {
            InviteCode inviteCode = new InviteCode(RandomStringUtils.randomAlphanumeric(32));
            inviteCode.setCreator(user);
            user.getInviteCodes().add(inviteCode);
        }
        user.setInviteNum(user.getInviteNum() - num);
        userRepository.saveOrUpdate(user);
    }

    public void generateAdminInviteCodes(int uid, int num) {
        for (int i = 0; i < num; i++) {
            inviteCodeRepository.saveAdminInviteCode(RandomStringUtils.randomAlphanumeric(32), uid);
        }
    }

}