package cc.cicadabear.web.validator;

import cc.cicadabear.domain.dto.user.AdminUserUpdateDto;
import cc.cicadabear.domain.dto.user.UserUpdateDto;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.service.UserService;
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
public class SsMethodUpdateDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserUpdateDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserUpdateDto dto = (UserUpdateDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "method", null, "加密方式不能为空");
        if (errors.hasErrors()) return;

        validateMethod(dto, errors);
        if (errors.hasErrors()) return;
    }

    public User resetUser(User user, UserUpdateDto dto) {
        user.setMethod(dto.getMethod());
        return user;
    }

    private void validateMethod(UserUpdateDto dto, Errors errors) {
        if (!Node.METHODS_LIST.contains(dto.getMethod())) {
            errors.reject(null, "连接方式不合法");
        }
    }

}
