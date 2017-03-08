package cc.cicadabear.web.controller.home;

import cc.cicadabear.common.util.SecurityUtils;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * Created by Jack on 3/7/17.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        logger.debug("test/test===========");
        ServletOutputStream stream = null;

        try {
            stream = ThreadLocalHolder.getResponse().getOutputStream();
            stream.println("session:" + ThreadLocalHolder.getRequest().getSession().getId());
            User user = SecurityUtils.currentUser();
//            User user = userService.loadUserByID(1);

            stream.println(user == null);
            stream.println(user.email());

//            Session session = sessionFactory.getCurrentSession();
            Session session = ThreadLocalHolder.getSession();

            stream.println(session.isOpen());

            logger.debug("====================" + String.valueOf(Thread.currentThread().getId()) + "====" + session.hashCode());


            stream.println(user.getInviteCodes() == null);

            stream.println(user.getInviteCodes().size());
            stream.println(user.getInvitees().size());

            stream.println(user.getInviter() == null);

            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "test";
    }

    @ResponseBody
    @RequestMapping("/clear_cache")
    public String clearCache() {
        Session session = sessionFactory.openSession();
        session.clear();
        return "clear_cache";
    }


}
