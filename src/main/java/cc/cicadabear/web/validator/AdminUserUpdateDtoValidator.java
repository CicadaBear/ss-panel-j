package cc.cicadabear.web.validator;

import cc.cicadabear.domain.dto.user.AdminUserUpdateDto;
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
public class AdminUserUpdateDtoValidator implements Validator {

    private User user;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return AdminUserUpdateDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminUserUpdateDto dto = (AdminUserUpdateDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "该用户不存在");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "邮箱不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "邮箱不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "连接密码不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "method", "加密方式不能为空");
        if (errors.hasErrors()) return;

        validateID(dto, errors);
        if (errors.hasErrors()) return;

        validateEmail(dto, errors);
        if (errors.hasErrors()) return;

        validatePassword(dto, errors);
        if (errors.hasErrors()) return;

        validateMethod(dto, errors);
        if (errors.hasErrors()) return;

    }

    public User getUser() {
        return user;
    }

    private void validateID(AdminUserUpdateDto dto, Errors errors) {
        user = userService.loadUserByID(dto.getId());
        if (user == null) {
            errors.reject(null, "该用户不存在");
        }
    }

    private void validateEmail(AdminUserUpdateDto dto, Errors errors) {
        if (!user.getEmail().equals(dto.getEmail())) {
            if (userService.isExistEmail(dto.getEmail())) {
                errors.reject(null, "Email已存在");
            }
        }
    }


    private void validatePassword(AdminUserUpdateDto dto, Errors errors) {
        if (StringUtils.isNotEmpty(dto.getPassword())) {
            if (dto.getPassword().length() < 6) {
                errors.reject(null, "登录密码位数不够");
            }
        }
        if (dto.getPass().length() < 6) {
            errors.reject(null, "连接密码位数不够");
        }
    }

    private void validateMethod(AdminUserUpdateDto dto, Errors errors) {
        if (!Node.METHODS_LIST.contains(dto.getMethod())) {
            errors.reject(null, "连接方式不合法");
        }
    }

}
