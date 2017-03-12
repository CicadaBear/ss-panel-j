package cc.cicadabear.web.controller.admin;

import cc.cicadabear.common.controller.ResultVo;
import cc.cicadabear.domain.dto.node.NodeDto;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.service.NodeService;
import cc.cicadabear.web.validator.NodeAddValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultVo add() {
//        ResultVo resultVo = new ResultVo();
//        return resultVo;
//    }


}
