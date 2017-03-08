package cc.cicadabear.web.validator;

import cc.cicadabear.common.util.MatchUtils;
import cc.cicadabear.domain.dto.user.UserLoginDto;
import cc.cicadabear.domain.dto.user.UserRegisterDto;
import cc.cicadabear.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Shengzhao Li
 */
@Component
public class UserLoginDtoValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserLoginDto.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserLoginDto formDto = (UserLoginDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "邮箱不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwd", null, "密码不能为空");

        if (errors.hasErrors()) return;

        validateEmail(formDto, errors);

        if (errors.hasErrors()) return;

        if (StringUtils.isEmpty(formDto.getPasswd())) {
            errors.reject("password", "密码不能为空");
        }


    }


    private void validateEmail(UserLoginDto userFormDto, Errors errors) {
        String email = userFormDto.getEmail();
        if (!MatchUtils.isEmail(email)) {
            errors.rejectValue("email", null, "错误的邮箱格式");
        }
        boolean exist = userService.isExistEmail(email);
        if (!exist) {
            errors.rejectValue("email", null, "账号不存在");
        }
    }

}