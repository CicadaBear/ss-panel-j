package cc.cicadabear.web.validator;

import cc.cicadabear.domain.dto.node.NodeDto;
import cc.cicadabear.domain.entity.Node;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Jack on 3/12/17.
 */
@Component
public class NodeAddValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return NodeDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NodeDto nodeDto = (NodeDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "节点名字不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "server", null, "节点地址不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "method", null, "加密方法不能为空");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "custom_method", "节点地址不能为空");
        validateMethod(nodeDto, errors);
    }

    private void validateMethod(NodeDto dto, Errors errors) {
        if (!Node.METHODS_LIST.contains(dto.getMethod())) {
            errors.rejectValue("method", null, "加密方法非法");
        }
    }


}
