package cc.cicadabear.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jack on 3/8/17.
 */
@RequestMapping("/password")
@Controller
public class PasswordController {

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public String reset() {

        return "password/reset";
    }


    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String handleReset() {

        return "password/reset";
    }


}
