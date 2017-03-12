package cc.cicadabear.web.validator;

import cc.cicadabear.domain.dto.user.AdminUserUpdateDto;
import cc.cicadabear.domain.dto.user.NodeUpdateDto;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.service.NodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Jack on 3/12/17.
 */
@Component
public class NodeUpdateDtoValidator implements Validator {

    @Autowired
    private NodeService nodeService;

    @Override
    public boolean supports(Class<?> clazz) {
        return AdminUserUpdateDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NodeUpdateDto dto = (NodeUpdateDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", null, "该节点不存在");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "名称不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate", null, "流量比例不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "method", null, "加密方式不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", null, "type不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "custom_method", null, "是否自定义密码不能为空");
        if (errors.hasErrors()) return;

        validateID(dto, errors);
        if (errors.hasErrors()) return;

        validateMethod(dto, errors);
        if (errors.hasErrors()) return;

        resetNode(dto.getNode(), dto);
    }

    public Node resetNode(Node node, NodeUpdateDto dto) {
        node.setName(dto.getName());
        node.setServer(dto.getServer());
        node.setTrafficRate(dto.getRate());
        node.setMethod(dto.getMethod());
        node.setInfo(dto.getInfo());
        node.setCustomMethod(dto.getCustomMethod() == 1);
        node.setStatus(dto.getStatus());
        node.setSort(dto.getSort());
        node.setType(dto.getType());
        return node;
    }

    private void validateID(NodeUpdateDto dto, Errors errors) {
        Node node = nodeService.loadNodeByID(dto.getId());
        dto.setNode(node);
        if (node == null) {
            errors.reject(null, "该节点不存在");
        }
    }

    private void validateMethod(NodeUpdateDto dto, Errors errors) {
        if (!Node.METHODS_LIST.contains(dto.getMethod())) {
            errors.reject(null, "连接方式不合法");
        }
    }

}
