package cc.cicadabear.web.controller.home;

import cc.cicadabear.common.ResultVo;
import cc.cicadabear.common.util.SecurityUtils;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.domain.shared.security.SecurityHolder;
import cc.cicadabear.service.InviteCodeService;
import cc.cicadabear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Jack on 3/7/17.
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private InviteCodeService inviteCodeService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", ""})
    public String index(Model model) {
        model.addAttribute("user", SecurityUtils.currentUser());
        return "user/index";
    }

    @RequestMapping(value = "/invite", method = RequestMethod.GET)
    public String invite(Model model) {
        User user = SecurityUtils.currentUser();
        List<InviteCode> codes = user.getInviteCodes();
//        ThreadLocalHolder.getSession().contains(user);
        model.addAttribute("user", user);
        model.addAttribute("codes", codes);
        return "user/invite";
    }

    @RequestMapping(value = "/invite", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo doInvite(int num) {
        ResultVo resultVo = new ResultVo();
        User user = SecurityUtils.currentUser();

        if (num < 1 || num > user.getInviteNum()) {
            resultVo.fail("您最多可生成" + user.getInviteNum() + "邀请码");
            return resultVo;
        }
        inviteCodeService.generateInviteCodes(user, num);
        resultVo.success("操作成功");
        return resultVo;
    }


}
