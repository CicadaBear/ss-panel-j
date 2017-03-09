package cc.cicadabear.web.controller.home;

import cc.cicadabear.common.ResultVo;
import cc.cicadabear.common.util.NumberUtils;
import cc.cicadabear.common.util.SecurityUtils;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.service.InviteCodeService;
import cc.cicadabear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jack on 3/7/17.
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private InviteCodeService inviteCodeService;

    @RequestMapping(value = {"/", ""})
    public String index(Model model) {
//        User user = SecurityUtils.currentUser();
//        user = userService.loadUserByID(user.id());
//        model.addAttribute("user", user);
        Map<String, Object> statistics = new HashMap();

        int totalUser = userService.loadCount();
        int totalNode = 0;
        int trafficUsage = 0;
        int checkinUser = 0;
        int onlineUser = 0;
        statistics.put("totalUser", totalUser);
        statistics.put("totalNode", totalNode);
        statistics.put("trafficUsage", trafficUsage);
        statistics.put("checkinUser", checkinUser);
        statistics.put("onlineUser", onlineUser);

        model.addAttribute("sts", statistics);

        return "admin/index";
    }

    @RequestMapping(value = "/invite", method = RequestMethod.GET)
    public String invite(Model model) {
        User user = SecurityUtils.currentUser();
        List<InviteCode> codes = user.getInviteCodes();
        model.addAttribute("codes", codes);
        return "admin/invite";
    }

    @RequestMapping(value = "/invite", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo doInvite(int uid, int num) {
        ResultVo resultVo = new ResultVo();
        inviteCodeService.generateAdminInviteCodes(uid, num);
        resultVo.success("操作成功");
        return resultVo;
    }

}
