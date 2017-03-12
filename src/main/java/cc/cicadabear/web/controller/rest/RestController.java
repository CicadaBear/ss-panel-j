package cc.cicadabear.web.controller.rest;

import cc.cicadabear.common.controller.ResultVo;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.service.InviteCodeService;
import cc.cicadabear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Jack on 3/7/17.
 */
@RequestMapping("/api")
@Controller
public class RestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    @ResponseBody
    public ResultVo users(int node) {
        ResultVo resultVo = new ResultVo();


        return resultVo;
    }


}
