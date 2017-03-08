package cc.cicadabear.web.controller.home;

import cc.cicadabear.common.util.SecurityUtils;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.domain.shared.security.SecurityHolder;
import cc.cicadabear.service.InviteCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Jack on 3/7/17.
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private InviteCodeService inviteCodeService;

    @RequestMapping(value = {"/", ""})
    public String index(Model model) {
        model.addAttribute("user", SecurityUtils.currentUser());
        return "user/index";
    }

    @RequestMapping("/invite")
    public String invite(Model model) {
        User user = SecurityUtils.currentUser();
        List<InviteCode> codes = user.getInviteCodes();

        model.addAttribute("user", user);
        model.addAttribute("codes", codes);
        return "user/invite";
    }


}
