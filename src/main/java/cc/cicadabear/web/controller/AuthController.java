package cc.cicadabear.web.controller;

import cc.cicadabear.common.controller.ResultVo;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.dto.user.UserLoginDto;
import cc.cicadabear.domain.dto.user.UserRegisterDto;
import cc.cicadabear.service.InviteCodeService;
import cc.cicadabear.service.UserService;
import cc.cicadabear.web.validator.UserLoginDtoValidator;
import cc.cicadabear.web.validator.UserRegisterDtoValidator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;

/**
 * Created by Jack on 3/8/17.
 */
@RequestMapping("/auth")
@Controller
public class AuthController {
    // Register Error Code
    public static final int ERROR_WRONG_CODE = 501;
    public static final int ERROR_ILLEGAL_EMAIL = 502;
    public static final int ERROR_PASSWORD_TOO_SHORT = 511;
    public static final int ERROR_PASSWORD_NOT_EQUAL = 512;
    public static final int ERROR_EMAILUSED = 521;

    // Login Error Code
    public static final int ERROR_USER_NOT_EXIST = 601;
    public static final int ERROR_USER_PASSWORD_WRONG = 602;

    // Verify Email

    public static final int ERROR_VERIFY_EMAIL_WRONG_EMAIL = 701;
    public static final int ERROR_VERIFY_EMAIL_EXIST = 702;


    @Autowired
    private UserService userService;

    @Autowired
    private InviteCodeService inviteCodeService;

    @Autowired
    private RememberMeServices rememberMeServices;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private UserLoginDtoValidator loginDtoValidator;

    @Autowired
    private UserRegisterDtoValidator registerDtoValidator;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "auth/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo doLogin(UserLoginDto dto, BindingResult br) {
        ResultVo resultVo = new ResultVo();
        loginDtoValidator.validate(dto, br);
        if (br.hasErrors()) {
            resultVo.fail(br.getAllErrors().get(0).getDefaultMessage());
            return resultVo;
        }

//        User user = userService.loadUserByEmail(dto.getEmail());
        try {
            userService.authenticate(dto.getEmail(), dto.getPasswd());
        } catch (AuthenticationException e) {
            resultVo.fail("用户名密码错误");
            resultVo.setErrorCode(ERROR_PASSWORD_NOT_EQUAL);
            return resultVo;
        } catch (Exception e) {
            resultVo.fail(e.getMessage());
            return resultVo;
        }
        if (StringUtils.isNotEmpty(dto.getRememberMe())) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            rememberMeServices.loginSuccess(ThreadLocalHolder.getRequest(), ThreadLocalHolder.getResponse(), authentication);
        }
        resultVo.success("登录成功");
        return resultVo;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(String code, Model model) {
        if (StringUtils.isNotEmpty(code)) {
            model.addAttribute("code", code);
        }
        return "auth/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo doRegister(UserRegisterDto registerDto, BindingResult br) {
        ResultVo resultVo = new ResultVo();
        registerDtoValidator.validate(registerDto, br);
        if (br.hasErrors()) {
            resultVo.fail(br.getAllErrors().get(0).getDefaultMessage());
            return resultVo;
        }
        userService.registerUser(registerDto);
        resultVo.success("注册成功");
        return resultVo;
    }

    @RequestMapping(value = "/sendCode", method = RequestMethod.POST)
    public String sendCode() {

        return "auth/login";
    }


}
