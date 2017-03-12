package cc.cicadabear.domain.repository;


import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.domain.shared.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author jack
 */

public interface InviteCodeRepository extends Repository {

    InviteCode findByNo(String code);

    List<InviteCode> findByUser(int userId);

    void insert(InviteCode inviteCode);
}