package cc.cicadabear.domain.repository.hibernate;

import cc.cicadabear.common.util.DateUtils;
import cc.cicadabear.domain.entity.AbstractEntity;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.repository.InviteCodeRepository;
import com.google.common.collect.ImmutableMap;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jack on 3/8/17.
 */
@Repository("inviteCodeRespostory")
public class InviteCodeRespostoryHibernate extends AbstractRepositoryHibernate<InviteCode> implements InviteCodeRepository {

    @Override
    public InviteCode findByNo(String code) {
        final List<InviteCode> list = find("from InviteCode c where c.code = :no ", ImmutableMap.of("no", code));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<InviteCode> findByUser(int userId) {
        return find("from InviteCode c where c.creator.id = :uid order by id ", ImmutableMap.of("uid", userId));
    }

    @Override
    public <T extends AbstractEntity> void saveOrUpdate(T domain) {
        if (domain.isNewly()) {
            ((InviteCode) domain).setCreatedAt(DateUtils.now());
        }
        ((InviteCode) domain).setUpdatedAt(DateUtils.now());
        super.saveOrUpdate(domain);
    }

    public void saveAdminInviteCode(String code, int uid) {
        Query query = session().createSQLQuery("INSERT INTO ss_invite_code (code, user_id, created_at,updated_at) VALUES (:code, :uid, :createdAt, :updatedAt)");
        query.setParameter("code", code);
        query.setParameter("uid", uid);
        query.setTimestamp("createdAt", DateUtils.now());
        query.setTimestamp("updatedAt", DateUtils.now());
        query.executeUpdate();
    }

}
