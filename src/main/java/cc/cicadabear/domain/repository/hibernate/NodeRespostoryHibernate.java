package cc.cicadabear.domain.repository.hibernate;

import cc.cicadabear.common.util.DateUtils;
import cc.cicadabear.domain.entity.AbstractEntity;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.domain.repository.InviteCodeRepository;
import cc.cicadabear.domain.repository.NodeRepository;
import com.google.common.collect.ImmutableMap;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.validation.Path;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Jack on 3/8/17.
 */
@Repository("nodeCodeRespostory")
public class NodeRespostoryHibernate extends AbstractRepositoryHibernate<Node> implements NodeRepository {


    @Override
    public Node findByID(int id) {
        final List<Node> list = find("from Node c where c.id = :id ", ImmutableMap.of("id", id));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Node> findAll() {
        return find("from Node c order by sort ");
    }

}
