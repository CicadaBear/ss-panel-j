package cc.cicadabear.web.controller;

import cc.cicadabear.common.controller.ResultVo;
import cc.cicadabear.common.util.SecurityUtils;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.dto.user.NodeUpdateDto;
import cc.cicadabear.domain.dto.user.UserUpdateDto;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.service.InviteCodeService;
import cc.cicadabear.service.NodeService;
import cc.cicadabear.service.UserService;
import cc.cicadabear.web.validator.SsMethodUpdateDtoValidator;
import cc.cicadabear.web.validator.SsPassUpdateDtoValidator;
import cc.cicadabear.web.validator.UserPasswordUpdateDtoValidator;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private NodeService nodeService;

    @Autowired
    private UserPasswordUpdateDtoValidator userPasswordUpdateDtoValidator;

    @Autowired
    private SsMethodUpdateDtoValidator ssMethodUpdateDtoValidator;

    @Autowired
    private SsPassUpdateDtoValidator ssPassUpdateDtoValidator;


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

    @RequestMapping(value = "/node")
    public String node(Model model) {
        List<Node> nodes = nodeService.loadNodes();
        model.addAttribute("nodes", nodes);
        return "user/node";
    }

    @RequestMapping("/node/{id}")
    public String nodeInfo(@PathVariable("id") int id, Model model) {
        Node node = nodeService.loadNodeByID(id);
        if (node == null) {
            String referer = ThreadLocalHolder.getRequest().getHeader("Referer");
            ThreadLocalHolder.getRequest().setAttribute("msg", "节点不存在");
            return "redirect:" + referer;
        }
        User user = SecurityUtils.currentUser();
        JSONObject json = new JSONObject();
        json.put("server", node.getServer());
        json.put("server_port", user.getPort());
        json.put("password", user.getPass());
        json.put("method", node.getMethod());
        if (node.isCustomMethod()) {
            json.put("method", user.getMethod());
        }
        String ssUrl = json.getString("method") +
                ":" + json.getString("password") +
                "@" + json.getString("server") +
                ":" + json.getString("server_port");
        String ssqr = "ss://" + new String(Base64.encodeBase64(ssUrl.getBytes()));

        String baseUrl = "http://" + ThreadLocalHolder.getRequest().getLocalName() + ":" + ThreadLocalHolder.getRequest().getLocalPort();
        String surgeBase = baseUrl + "/downloads/ProxyBase.conf";

        String surgeProxy = "#!PROXY-OVERRIDE:ProxyBase.conf\n";
        surgeProxy += "[Proxy]\n";
        surgeProxy += "Proxy = custom," + json.getString("server") + ","
                + json.getString("server_port") + "," + json.getString("method") + "," + json.getString("password") + "," + baseUrl + "/downloads/SSEncrypt.module";

        model.addAttribute("node", node);
        model.addAttribute("json", json);
        model.addAttribute("ssUrl", ssUrl);
        model.addAttribute("ssqr", ssqr);
        model.addAttribute("surgeBase", surgeBase);
        model.addAttribute("surgeProxy", surgeProxy);

        return "user/nodeinfo";
    }

    @RequestMapping(value = "/profile")
    public String profile(Model model) {
//        List<Node> nodes = nodeService.loadNodes();
//        model.addAttribute("nodes", nodes);
        return "user/profile";
    }

    @RequestMapping(value = "/edit")
    public String edit(Model model) {
        model.addAttribute("methods", Node.METHODS_LIST);
        return "user/edit";
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo password(UserUpdateDto dto, BindingResult br) {
        ResultVo resultVo = new ResultVo();
        userPasswordUpdateDtoValidator.validate(dto, br);
        if (br.hasErrors()) {
            resultVo.fail(br.getAllErrors().get(0).getDefaultMessage());
            return resultVo;
        }
        User user = SecurityUtils.currentUser();
        userPasswordUpdateDtoValidator.resetUser(user, dto);
        userService.saveOrUpdate(user);
        resultVo.success("操作成功");
        return resultVo;
    }

    @RequestMapping(value = "/sspwd", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo sspwd(UserUpdateDto dto, BindingResult br) {
        ResultVo resultVo = new ResultVo();
        ssPassUpdateDtoValidator.validate(dto, br);
        if (br.hasErrors()) {
            resultVo.fail(br.getAllErrors().get(0).getDefaultMessage());
            return resultVo;
        }
        User user = SecurityUtils.currentUser();
        ssPassUpdateDtoValidator.resetUser(user, dto);
        userService.saveOrUpdate(user);
        resultVo.success("操作成功");
        return resultVo;
    }

    @RequestMapping(value = "/method", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo method(UserUpdateDto dto, BindingResult br) {
        ResultVo resultVo = new ResultVo();
        ssMethodUpdateDtoValidator.validate(dto, br);
        if (br.hasErrors()) {
            resultVo.fail(br.getAllErrors().get(0).getDefaultMessage());
            return resultVo;
        }
        User user = SecurityUtils.currentUser();
        ssMethodUpdateDtoValidator.resetUser(user, dto);
        userService.saveOrUpdate(user);
        resultVo.success("操作成功");
        return resultVo;
    }
}
