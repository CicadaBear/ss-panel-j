package cc.cicadabear.web.controller.rest;

import cc.cicadabear.common.controller.ResultVo;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by Jack on 3/7/17.
 */
@RequestMapping("/mu")
@Controller
public class RestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    @ResponseBody
    public ResultVo users() throws IOException {
        ResultVo resultVo = new ResultVo();
        List<User> list = userService.loadAll();
        resultVo.setData(list);
        resultVo.success("ok");
        return resultVo;
    }


}
