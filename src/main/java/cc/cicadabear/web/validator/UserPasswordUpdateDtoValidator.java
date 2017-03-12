package cc.cicadabear.web.validator;

import cc.cicadabear.common.util.PasswordHandler;
import cc.cicadabear.common.util.SecurityUtils;
import cc.cicadabear.domain.dto.user.UserUpdateDto;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Jack on 3/12/17.
 */
@Component
public class UserPasswordUpdateDtoValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserUpdateDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserUpdateDto dto = (UserUpdateDto) target;
        User user = SecurityUtils.currentUser();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldpwd", null, "加密方式不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", null, "加密方式不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repwd", null, "加密方式不能为空");
        if (errors.hasErrors()) return;

        validatePassword(dto, errors, user);
        if (errors.hasErrors()) return;

    }

    public User resetUser(User user, UserUpdateDto dto) {
        user.setPassword(PasswordHandler.encryptPassword(dto.getPwd()));
        return user;
    }

    private void validatePassword(UserUpdateDto dto, Errors errors, User user) {
        if (!PasswordHandler.encryptPassword(dto.getOldpwd()).equals(user.getPassword())) {
            errors.reject(null, "原密码不正确");
            return;
        }
        if (!dto.getPwd().equals(dto.getRepwd())) {
            errors.reject(null, "两次密码不一致");
            return;
        }
        if (dto.getPwd().length() < 6) {
            errors.reject(null, "密码位数不够");
            return;
        }
    }
}
