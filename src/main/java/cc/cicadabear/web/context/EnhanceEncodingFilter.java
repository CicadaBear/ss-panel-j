package cc.cicadabear.web.context;

import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.common.util.WebUtils;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Wrap the spring <i>CharacterEncodingFilter</i>, add retrieve client ip action
 * <p/>
 * <p/>
 * 扩展 默认的 CharacterEncodingFilter, 添加对IP 地址的获取
 *
 * @author Shengzhao Li
 */
public class EnhanceEncodingFilter extends CharacterEncodingFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        logger.debug("before=========openSession");
//        sessionFactory.openSession();
        persistIp(request);
        persistReqResp(request, response);

        super.doFilterInternal(request, response, filterChain);
//        sessionFactory.getCurrentSession().close();
        logger.debug("after=========closeSession");


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