package cc.cicadabear.service.impl;

import cc.cicadabear.domain.dto.node.NodeDto;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.domain.repository.NodeRepository;
import cc.cicadabear.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jack
 */
@Service("nodeService")
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    @Override
    public Node loadNodeByID(int id) {
        return nodeRepository.findByID(id);
    }

    @Override
    public List<Node> loadNodes() {
        return nodeRepository.findAll();
    }

    public void addNode(NodeDto nodeDto) {
        nodeRepository.saveOrUpdate(nodeDto.toEntity());
    }

    @Override
    public void deleteNode(int id) {
        nodeRepository.delete(nodeRepository.findByID(id));
    }
}