package cc.cicadabear.web.context;

import cc.cicadabear.common.config.JConfig;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.common.util.WebUtils;
import net.sf.json.JSONObject;
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
public class ApiFilter extends OncePerRequestFilter {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.debug("start");
        if (request.getRequestURI().contains("/api")) {
            String key = (String) request.getAttribute("key");
            if (key != null && JConfig.getConfig("muKey").equals(key)) {
                filterChain.doFilter(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "un authorized");
                JSONObject json = new JSONObject();
                json.put("ret", 1);
                json.put("error_code", 401);
                json.put("msg", "请传入正确的key");
                json.write(response.getWriter());
            }
        } else {
            filterChain.doFilter(request, response);
        }

    }
}
