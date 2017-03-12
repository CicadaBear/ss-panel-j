package cc.cicadabear.service;

import cc.cicadabear.domain.dto.node.NodeDto;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.domain.entity.User;

import java.util.List;

/**
 * @author Shengzhao Li
 */
public interface NodeService {

    Node loadNodeByID(int id);

    List<Node> loadNodes();

    void addNode(NodeDto nodeDto);

    void deleteNode(int id);

    void saveOrUpdate(Node node);

}