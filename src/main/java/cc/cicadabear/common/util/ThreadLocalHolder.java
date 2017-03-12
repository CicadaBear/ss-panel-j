package cc.cicadabear.common.util;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Shengzhao Li
 */
public abstract class ThreadLocalHolder {

    private static ThreadLocal<String> clientIpThreadLocal = new ThreadLocal<String>();

    private static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>();

    private static ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<HttpServletResponse>();

    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();

    private static ThreadLocal<ServletContext> servletContextThreadLocal = new ThreadLocal<ServletContext>();
    private static ThreadLocal<ApplicationContext> applicationContextThreadLocal = new ThreadLocal<ApplicationContext>();


    protected ThreadLocalHolder() {
    }

    public static void clientIp(String clientIp) {
        clientIpThreadLocal.set(clientIp);
    }

    public static String clientIp() {
        return clientIpThreadLocal.get();
    }

    public static void setThreadLocalRequest(HttpServletRequest servletRequest) {
        requestThreadLocal.set(servletRequest);
    }

    public static HttpServletRequest getThreadLocalRequest() {
        return requestThreadLocal.get();
    }

    public static HttpServletRequest getRequest() {
        return requestThreadLocal.get();
    }

    public static void setThreadLocalResponse(HttpServletResponse servletResponse) {
        responseThreadLocal.set(servletResponse);
    }

    public static HttpServletResponse getThreadLocalResponse() {
        return responseThreadLocal.get();
    }

    public static HttpServletResponse getResponse() {
        return responseThreadLocal.get();
    }

    public static void setThreadLocalSession(Session session) {
        sessionThreadLocal.set(session);
    }

    public static Session getSession() {
        return sessionThreadLocal.get();
    }

    public static void setThreadLocalServletContext(ServletContext servletContext) {
        servletContextThreadLocal.set(servletContext);
    }

    public static ServletContext getServletContext() {
        return servletContextThreadLocal.get();
    }

    public static void setThreadLocalApplicationContext(ApplicationContext applicationContext) {
        applicationContextThreadLocal.set(applicationContext);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContextThreadLocal.get();
    }

}