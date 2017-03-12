package cc.cicadabear.web.controller.admin;

import cc.cicadabear.common.controller.ResultVo;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.dto.node.NodeDto;
import cc.cicadabear.domain.dto.user.AdminUserUpdateDto;
import cc.cicadabear.domain.dto.user.NodeUpdateDto;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.service.NodeService;
import cc.cicadabear.web.validator.NodeAddValidator;
import cc.cicadabear.web.validator.NodeUpdateDtoValidator;
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

/**
 * Created by Jack on 3/7/17.
 */
@RequestMapping("/admin/node")
@Controller
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private NodeAddValidator nodeAddValidator;

    @Autowired
    private NodeUpdateDtoValidator nodeUpdateDtoValidator;

    @RequestMapping(value = {"/", ""})
    public String index(Model model) {
        List<Node> nodes = nodeService.loadNodes();
        model.addAttribute("nodes", nodes);
        return "/admin/node/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("methods", Node.METHODS_LIST);
        return "/admin/node/create";
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    @ResponseBody
    public ResultVo add(NodeDto nodeDto, BindingResult br) {
        ResultVo resultVo = new ResultVo();
        nodeAddValidator.validate(nodeDto, br);
        if (br.hasErrors()) {
            resultVo.fail(br.getAllErrors().get(0).getDefaultMessage());
            return resultVo;
        }
        nodeService.addNode(nodeDto);
        resultVo.success("添加成功");
        return resultVo;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultVo delete(@PathVariable("id") int id) throws Exception {
        ResultVo resultVo = new ResultVo();
        nodeService.deleteNode(id);
        resultVo.success("操作成功");
        return resultVo;
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, Model model) {
        Node node = nodeService.loadNodeByID(id);
//        User user = userService.loadUserByID(3);
        if (node == null) {
            String referer = ThreadLocalHolder.getRequest().getHeader("Referer");
            ThreadLocalHolder.getRequest().setAttribute("msg", "节点不存在");
            return "redirect:" + referer;
        }
        model.addAttribute("node", node);
        model.addAttribute("methods", Node.METHODS_LIST);
        return "admin/node/edit";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResultVo update(NodeUpdateDto dto, BindingResult br) {
        ResultVo resultVo = new ResultVo();
        nodeUpdateDtoValidator.validate(dto, br);
        if (br.hasErrors()) {
            resultVo.fail(br.getAllErrors().get(0).getDefaultMessage());
            return resultVo;
        }
        nodeService.saveOrUpdate(dto.getNode());
        resultVo.success("操作成功");
        return resultVo;
    }

}
