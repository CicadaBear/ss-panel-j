package cc.cicadabear.domain.repository.hibernate;

import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.entity.AbstractEntity;
import cc.cicadabear.domain.shared.Repository;
import com.google.common.collect.ImmutableMap;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.util.Assert;
import sun.rmi.runtime.Log;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Shengzhao Li
 */
public abstract class AbstractRepositoryHibernate<T> implements Repository, InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(sessionFactory, "SessionFactory is required!");
    }

    protected Session session() {
//        Session session = sessionFactory.getCurrentSession();
        Session session = ThreadLocalHolder.getSession();
        logger.debug("====================" + String.valueOf(Thread.currentThread().getId()) + "====" + session.hashCode());
        return session;
    }

    /*
    * It is ext. HibernateTemplate
    */
    @SuppressWarnings("unchecked")
    protected <T extends AbstractEntity> List<T> find(final String queryString, final ImmutableMap<String, ?> paramsMap) throws DataAccessException {
        Query queryObject = session().createQuery(queryString);
        if (paramsMap != null) {
            for (String key : paramsMap.keySet()) {
                queryObject.setParameter(key, paramsMap.get(key));
            }
        }
        return queryObject.list();
    }

    @SuppressWarnings("unchecked")
    protected <T extends AbstractEntity> T findOne(final String queryString, final ImmutableMap<String, ?> paramsMap) throws DataAccessException {
        Query queryObject = session().createQuery(queryString);
        if (paramsMap != null) {
            for (String key : paramsMap.keySet()) {
                queryObject.setParameter(key, paramsMap.get(key));
            }
        }
        queryObject.setFirstResult(0);
        queryObject.setMaxResults(1);
        List<T> list = queryObject.list();
        return list.size() > 0 ? list.get(0) : null;
    }


    protected <T extends AbstractEntity> List<T> find(final String queryString) throws DataAccessException {
        return find(queryString, null);
    }

    @Override
    public <T extends AbstractEntity> T findById(Integer id, Class<T> clazz) {
        List<T> list = find("from " + clazz.getSimpleName() + " do where do.id = :id", ImmutableMap.of("id", id));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public <T extends AbstractEntity> void saveOrUpdate(T domain) {
        session().saveOrUpdate(domain);
    }

    @Override
    public <T extends AbstractEntity> void saveOrUpdateAll(Collection<T> collection) {
        for (T t : collection) {
            saveOrUpdate(t);
        }
    }

    @Override
    public <T extends AbstractEntity> void delete(T domain) {
        session().delete(domain);
    }


    @Override
    public <T extends AbstractEntity> void deleteAll(Collection<T> elements) {
        for (T element : elements) {
            delete(element);
        }
    }

    @Override
    public <T extends AbstractEntity> List<T> findAll(Class<T> clazz) {
        return find("from " + clazz.getName() + " c ");
    }
}