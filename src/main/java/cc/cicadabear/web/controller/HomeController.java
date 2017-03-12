package cc.cicadabear.web.controller;

import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.service.InviteCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Jack on 3/7/17.
 */
@RequestMapping("/")
@Controller
public class HomeController {

    @Autowired
    private InviteCodeService inviteCodeService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/code")
    public String code(Model model) {
        List<InviteCode> codes = inviteCodeService.loadCodesByUser(0);
        model.addAttribute("codes", codes);
        return "code";
    }

    @RequestMapping("/tos")
    public String tos() {
        return "tos";
    }

    @RequestMapping(value = "/debug", method = RequestMethod.GET)
    public Object debug() {
        return "debug";
    }

    @RequestMapping(value = "/debug", method = RequestMethod.POST)
    public Object postDebug() {
        return "debug";
    }

}
