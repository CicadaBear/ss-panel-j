package cc.cicadabear.domain.repository.hibernate;

import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.repository.InviteCodeRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jack on 3/8/17.
 */
@Repository("inviteCodeRespostory")
public class InviteCodeRespostoryHibernate extends AbstractRepositoryHibernate<InviteCode> implements InviteCodeRepository {

    @Override
    public InviteCode findByNo(String code) {
        final List<InviteCode> list = find("from InviteCode c where c.code = :no ", ImmutableMap.of("code", code));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<InviteCode> findByUser(int userId) {
        return find("from InviteCode c where c.creator = :uid order by id ", ImmutableMap.of("uid", userId));
    }


}
