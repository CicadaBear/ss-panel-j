package cc.cicadabear.web.validator;

import cc.cicadabear.common.util.MatchUtils;
import cc.cicadabear.domain.dto.user.UserRegisterDto;
import cc.cicadabear.service.InviteCodeService;
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
public class UserRegisterDtoValidator implements Validator {

    @Autowired
    private UserService userService;

    @Autowired
    private InviteCodeService inviteCodeService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegisterDto.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRegisterDto formDto = (UserRegisterDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "邮箱不能为空");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "用户名不能为空");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "密码不能为空");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", null, "邀请码不能为空");


        if (errors.hasErrors()) return;

        validateEmail(formDto, errors);

        if (errors.hasErrors()) return;

        validatePassword(formDto, errors);

        if (errors.hasErrors()) return;

        validateInviteCode(formDto, errors);

    }


    private void validateEmail(UserRegisterDto userFormDto, Errors errors) {
        String email = userFormDto.getEmail();
        if (!MatchUtils.isEmail(email)) {
            errors.rejectValue("email", null, "错误的邮箱格式");
        }
        boolean exist = userService.isExistEmail(userFormDto.getEmail());
        if (exist) {
            errors.rejectValue("email", null, "邮箱已经存在");
        }
    }

    private void validateInviteCode(UserRegisterDto dto, Errors errors) {
        String code = dto.getCode();
        if (!inviteCodeService.isExistByNo(dto.getCode())) {
            errors.rejectValue("code", null, "邀请码无效");
        }
    }

    protected void validatePassword(UserRegisterDto dto, Errors errors) {
        String password = dto.getPassword();
        String rePassword = dto.getRePassword();
        if (password == null || password.length() < 6) {
            errors.rejectValue("passwd", null, "密码长度 >= 6");
            return;
        }
        if (!password.equals(rePassword)) {
            errors.rejectValue("repasswd", null, "两数输入密码不同");
        }
    }
}