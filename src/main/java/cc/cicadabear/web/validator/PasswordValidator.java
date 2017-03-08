package cc.cicadabear.web.validator;

import cc.cicadabear.domain.dto.user.UserRegisterDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Shengzhao Li
 */
@Component
public class PasswordValidator implements Validator {

    protected static final int MIN_PASSWORD_LENGTH = 6;


    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserRegisterDto.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegisterDto dto = (UserRegisterDto) o;
        validatePassword(dto.getPassword(), dto.getRePassword(), errors);
    }


    protected void validatePassword(String password, String rePassword, Errors errors) {

        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            errors.rejectValue("passwd", null, "密码长度 >= 6");
            return;
        }

        if (!password.equals(rePassword)) {
            errors.rejectValue("repasswd", null, "两数输入密码不同");
        }
    }

}