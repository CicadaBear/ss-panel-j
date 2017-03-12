package cc.cicadabear.web.controller.admin;

import cc.cicadabear.common.controller.ResultVo;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.dto.user.AdminUserUpdateDto;
import cc.cicadabear.domain.dto.user.UserListDto;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.service.UserService;
import cc.cicadabear.web.validator.AdminUserUpdateDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;

/**
 * Created by Jack on 3/11/17.
 */
@RequestMapping("/admin/user")
@Controller("admin.userController")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminUserUpdateDtoValidator userUpdateDtoValidator;


    @RequestMapping(value = {"/", ""})
    public String index(UserListDto dto, Model model) {
        userService.loadUserListDto(dto);
        dto.setRequestPath(ThreadLocalHolder.getRequest().getRequestURI());
        model.addAttribute("listDto", dto);
        return "admin/user/index";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, Model model) {
        User user = userService.loadUserByID(id);
//        User user = userService.loadUserByID(3);
        if (user == null) {
            String referer = ThreadLocalHolder.getRequest().getHeader("Referer");
            ThreadLocalHolder.getRequest().setAttribute("msg", "用户不存在");
            return "redirect:" + referer;
        }
        model.addAttribute("member", user);
        model.addAttribute("methods", Node.METHODS_LIST);
        return "admin/user/edit";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultVo delete(@PathVariable("id") int id) throws Exception {
        ResultVo resultVo = new ResultVo();
        userService.deleteUser(id);
        resultVo.success("操作成功");
        return resultVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResultVo update(AdminUserUpdateDto dto, BindingResult br, ServletRequest request) {
        ResultVo resultVo = new ResultVo();
        userUpdateDtoValidator.validate(dto, br);
        if (br.hasErrors()) {
            resultVo.fail(br.getAllErrors().get(0).getDefaultMessage());
            return resultVo;
        }
        userService.saveOrUpdate(dto.getUser());
        resultVo.success("操作成功");
        return resultVo;
    }


}
