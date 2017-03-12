package cc.cicadabear.domain.repository.hibernate;

import cc.cicadabear.common.hibernate.queryhelper.impl.ListUsersQueryHelper;
import cc.cicadabear.common.util.DateUtils;
import cc.cicadabear.domain.entity.AbstractEntity;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.domain.repository.UserRepository;
import com.google.common.collect.ImmutableMap;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @author Shengzhao Li
 */
@Repository("userRepository")
public class UserRepositoryHibernate extends AbstractRepositoryHibernate<User> implements UserRepository {

    @Override
    public User findByUsername(String username) {
        final List<User> list = find("from User u where u.username = :username", ImmutableMap.of("username", username));
        return list.isEmpty() ? null : list.get(0);
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<Privilege> findUserPrivileges(User user) {
//        final String hql = " select up.privilege from UserPrivilege up where up.archived = false and up.user = :user";
//        final Query query = session().createQuery(hql)
//                .setParameter("user", user);
//        return query.list();
//    }

    @Override
    public List<User> findListUsers(Map<String, Object> map) {
        ListUsersQueryHelper queryHelper = new ListUsersQueryHelper(session(), map);
        return queryHelper.getResults();
    }

    @Override
    public int totalListUsers(Map<String, Object> map) {
        ListUsersQueryHelper queryHelper = new ListUsersQueryHelper(session(), map);
        return queryHelper.getAmount();
    }

    @Override
    public User findByUsernameIgnoreArchived(String username) {
        final List<User> list = find("from User u where u.username = :username ", ImmutableMap.of("username", username));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public User findByEmail(String email) {
        final List<User> list = find("from User u where u.email = :email ", ImmutableMap.of("email", email));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int findLastPort() {
//        final User user = findOne("from User u order by id desc ", null);
////        return user == null ? 1024 : user.getPort();
        return ((Number) session().createCriteria(User.class).setProjection(Projections.max("port")).uniqueResult()).intValue();
    }

    @Override
    public int findCount() {
        return ((Number) session().createCriteria(User.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }

//    @Override
//    public <T extends AbstractEntity> void saveOrUpdate(T domain) {
//        User user = (User) domain;
//        if (user.id() != 0) {
//            super.saveOrUpdate(domain);
//        } else if (user.getInviter() != null && user.getInviter().id() != 0) {
//            super.saveOrUpdate(domain);
//        }else {
//            insert(user);
//        }
//    }

    public void insert(User user) {
        Query query = session().createSQLQuery("INSERT INTO user " +
                "(user_name, email, pass, passwd, t, u, d, transfer_enable,port,protocol,obfs,switch,enable,type,last_get_gift_time,last_check_in_time,last_rest_pass_time,reg_date,invite_num,is_admin,ref_by,expire_time,method,is_email_verify,reg_ip) " + "VALUES " +
                "(:user_name,:email,:pass,:passwd,:t,:u,:d,:transfer_enable,:port,:protocol,:obfs,:switch,:enable,:type,:last_get_gift_time,:last_check_in_time,:last_rest_pass_time,:reg_date,:invite_num,:is_admin,:ref_by,:expire_time,:method, :is_email_verify, :reg_ip)");
        query.setParameter("user_name", user.getUsername());
        query.setParameter("email", user.getEmail());
        query.setParameter("pass", user.getPass());
        query.setParameter("passwd", user.getPassword());
        query.setParameter("t", user.getT());
        query.setParameter("u", user.getU());
        query.setParameter("d", user.getD());
        query.setParameter("transfer_enable", user.getTransferEnable());
        query.setParameter("port", user.getPort());
        query.setParameter("protocol", user.getProtocol());
        query.setParameter("obfs", user.getObfs());
        query.setParameter("switch", user.getSwitch());
        query.setParameter("enable", user.getEnable());
        query.setParameter("type", user.getType());
        query.setParameter("last_get_gift_time", user.getLastGetGiftTime());
        query.setParameter("last_check_in_time", user.getLastCheckInTime());
        query.setParameter("last_rest_pass_time", user.getLastRestPassTime());

        //ref_by,expire_time,method,is_email_verify,reg_ip,
        query.setTimestamp("reg_date", user.getRegDate());
        query.setParameter("invite_num", user.getInviteNum());
        query.setParameter("is_admin", user.isAdmin());
        query.setParameter("is_admin", user.isAdmin());
        User inviter = user.getInviter();
        int refBy = inviter == null ? 0 : inviter.id();
        query.setParameter("ref_by", refBy);
        query.setParameter("expire_time", user.getExpireTime());
        query.setParameter("method", user.getMethod());
        query.setParameter("is_email_verify", user.getIsEmailVerify());
        query.setParameter("reg_ip", user.getRegIp());
        query.executeUpdate();
        int lastId = ((BigInteger) session().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
        user.id(lastId);
    }
}