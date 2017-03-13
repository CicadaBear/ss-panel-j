package cc.cicadabear.domain.shared;

import cc.cicadabear.domain.entity.AbstractEntity;

import java.util.Collection;
import java.util.List;

/**
 * @author Shengzhao Li
 */

public interface Repository {

    <T extends AbstractEntity> T findById(Integer id, Class<T> clazz);

    <T extends AbstractEntity> void saveOrUpdate(T domain);

    <T extends AbstractEntity> void saveOrUpdateAll(Collection<T> collection);

    <T extends AbstractEntity> void delete(T domain);

    <T extends AbstractEntity> void deleteAll(Collection<T> elements);

    <T extends AbstractEntity> List<T> findAll(Class<T> clazz);


}