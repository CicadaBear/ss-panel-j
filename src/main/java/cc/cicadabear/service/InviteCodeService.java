package cc.cicadabear.service;

import cc.cicadabear.domain.dto.user.*;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author Shengzhao Li
 */
public interface InviteCodeService {

    InviteCode loadCodeByNo(String code);

    boolean isExistByNo(String code);

    List<InviteCode> loadCodesByUser(int userId);

    void generateInviteCodes(User user, int num);

    void generateAdminInviteCodes(int uid, int num);
}