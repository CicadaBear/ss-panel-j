package cc.cicadabear.web.controller;

import cc.cicadabear.common.config.JConfig;
import cc.cicadabear.common.util.BandwidthUtils;
import cc.cicadabear.common.util.SecurityUtils;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.dto.user.UserDto;
import cc.cicadabear.domain.dto.user.UserListDto;
import cc.cicadabear.domain.dto.user.UserRegisterDto;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.service.InviteCodeService;
import cc.cicadabear.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

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

    @Autowired
    private InviteCodeService inviteCodeService;

    @ResponseBody
    @RequestMapping("/test")
    public String test() throws IOException {
        logger.debug("test/test===========");
        ServletOutputStream stream = null;

        stream = ThreadLocalHolder.getResponse().getOutputStream();
        stream.println("session:" + ThreadLocalHolder.getRequest().getSession().getId());
//            User user = SecurityUtils.currentUser();
        User user = userService.loadUserByID(1);

        stream.println(user == null);
        stream.println(user.email());
        stream.println(hashCode());

//            Session session = sessionFactory.getCurrentSession();
//            Session session = ThreadLocalHolder.getSession();

//            stream.println(session.isOpen());

//            logger.debug("====================" + String.valueOf(Thread.currentThread().getId()) + "====" + session.hashCode());


//            stream.println(user.getInviteCodes() == null);
//
//            stream.println(user.getInviteCodes().size());
//            stream.println(user.getInvitees().size());
//
//            stream.println(user.getInviter() == null);
//        stream.println(RandomStringUtils.randomAlphanumeric(32));
//
//        stream.println(BandwidthUtils.flowAutoShow(0));
//        stream.println(BandwidthUtils.flowAutoShow(1));
//        stream.println(BandwidthUtils.flowAutoShow(1024 * 1024));
//        inviteCodeService.generateAdminInviteCodes(null, 50);
//        List<InviteCode> inviteCodeList = inviteCodeService.loadCodesByUser(0);
//        for (int i = 0; i < inviteCodeList.size() - 15; i++) {
//            stream.println(i);
//            UserRegisterDto userDto = new UserRegisterDto();
//            userDto.setUsername("Jack" + inviteCodeList.get(i).id());
//            userDto.setPasswd("123456");
//            userDto.setEmail("jack" + inviteCodeList.get(i).id() + "@cicadabear.cc");
//            userDto.setCode(inviteCodeList.get(i).getCode());
//            userService.registerUser(userDto);
//        }
//        UserListDto userListDto = new UserListDto();
//        userService.loadUserListDto(userListDto);
//        stream.println(userListDto.getUserList().toString());
//        stream.println(userListDto.render());
//        stream.println(ThreadLocalHolder.getRequest().getRequestURI());
        userService.deleteUser(15);
        stream.flush();



////        User user = SecurityUtils.currentUser();
//        user = userService.loadUserByID(1);
//        user.setUsername("admin1234");
//        userService.saveOrUpdate(user);
////        ThreadLocalHolder.getSession().flush();
//        System.out.println("==================" + ThreadLocalHolder.getSession().getClass());
//        user.setUsername("admin12346");
//        userService.saveOrUpdate(user);


        return "test";
    }

    @ResponseBody
    @RequestMapping("/clear_cache")
    public String clearCache() {
        Session session = sessionFactory.openSession();
        session.clear();
        return "clear_cache";
    }

    @RequestMapping("/test_html")
    public String testHtml(Model model) {
        String str = JConfig.getConfig("paging.banner.first");

        model.addAttribute("test", str);
        return "test";
    }


}
