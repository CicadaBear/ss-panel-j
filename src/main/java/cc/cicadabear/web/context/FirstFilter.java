package cc.cicadabear.web.context;

import cc.cicadabear.common.util.SecurityUtils;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.common.util.WebUtils;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jack on 2/22/17.
 */
public class FirstFilter extends OncePerRequestFilter {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private ApplicationContext applicationContext;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.debug("=========opensessoin");

        Session session = sessionFactory.openSession();
        session.setFlushMode(FlushMode.COMMIT);
        ThreadLocalHolder.setThreadLocalSession(session);
        persistIp(request);
        persistReqResp(request, response);

        ThreadLocalHolder.setThreadLocalServletContext(servletContext);
        ThreadLocalHolder.setThreadLocalApplicationContext(applicationContext);

        //isLogin
//        if (SecurityUtils.isLogin()) {
//            request.setAttribute("user", SecurityUtils.currentUser());
//        }


        filterChain.doFilter(request, response);
        ThreadLocalHolder.getSession().close();
        logger.debug("=========colsesessoin");
    }


    /*
    * 将IP地址 放置在 ThreadLocal 中
    * */
    private void persistIp(HttpServletRequest request) {
        final String clientIp = WebUtils.retrieveClientIp(request);
        ThreadLocalHolder.clientIp(clientIp);
    }

    private void persistReqResp(HttpServletRequest request, HttpServletResponse response) {
        ThreadLocalHolder.setThreadLocalRequest(request);
        ThreadLocalHolder.setThreadLocalResponse(response);
    }
}
