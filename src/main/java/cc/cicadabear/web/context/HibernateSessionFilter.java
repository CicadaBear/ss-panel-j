package cc.cicadabear.web.context;

import cc.cicadabear.common.util.ThreadLocalHolder;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jack on 2/22/17.
 */
public class HibernateSessionFilter extends OncePerRequestFilter

{
    @Autowired
    private SessionFactory sessionFactory;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.debug("=========opensessoin");
        ThreadLocalHolder.setThreadLocalSession(sessionFactory.openSession());
        filterChain.doFilter(request, response);
        ThreadLocalHolder.getSession().close();
        logger.debug("=========colsesessoin");
    }
}
