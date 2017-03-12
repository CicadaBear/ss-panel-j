package cc.cicadabear.domain.repository;


import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.domain.shared.Repository;

import javax.validation.Path;
import java.util.List;

/**
 * @author jack
 */

public interface NodeRepository extends Repository {

    Node findByID(int id);

    List<Node> findAll();

//    void insert(InviteCode inviteCode);
}