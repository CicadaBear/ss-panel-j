package cc.cicadabear.domain.repository.hibernate;

import cc.cicadabear.common.hibernate.queryhelper.impl.ListUsersQueryHelper;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.domain.repository.UserRepository;
import com.google.common.collect.ImmutableMap;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Shengzhao Li
 */
@Repository("userRepository")
public class UserRepositoryHibernate extends AbstractRepositoryHibernate<User> implements UserRepository {

    @Override
    public User findByUsername(String username) {
        final List<User> list = find("from User u where u.username = :username and u.archived = false", ImmutableMap.of("username", username));
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
}