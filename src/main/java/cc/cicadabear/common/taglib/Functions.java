package cc.cicadabear.common.taglib;


import cc.cicadabear.common.config.JConfig;
import cc.cicadabear.common.util.DateUtils;
import cc.cicadabear.common.util.SecurityUtils;
import cc.cicadabear.domain.entity.User;
import org.springframework.util.CollectionUtils;

import java.util.Date;

/**
 * 系统标签函数
 *
 * @author cc
 */
public class Functions {

//    private static SessionDAO sessionDAO = SpringUtils.getBean(SessionDAO.class);

    /**
     * 判断是否在集合中
     *
     * @param iterable
     * @param element
     * @return
     */
    public static boolean in(Iterable<?> iterable, Object element) {
        if (iterable == null) {
            return false;
        }
        return CollectionUtils.contains(iterable.iterator(), element);
    }

    /**
     * 获取在线用户列表
     *
     * @return
     */
//    public static Collection<Session> getOnlineUser() {
//        Collection<Session> sessions = sessionDAO.getActiveSessions();
//        return sessions;
//    }

    /**
     * 获取session 账号
     *
     * @param session
     * @return
     */
//    public static String principal(Session session) {
//        PrincipalCollection principalCollection = (PrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
//        if (principalCollection == null)
//            return "";
//        else
//            return (String) principalCollection.getPrimaryPrincipal();
//    }

    /**
     * 判断是否强制退出
     * @param session
     * @return
     */
//	public static boolean isForceLogout(Session session) {
//		return session.getAttribute(JConfig.SESSION_FORCE_LOGOUT_KEY) != null;
//	}

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static User getLoginUser() {
        return SecurityUtils.currentUser();
    }

    public static boolean isLogin() {
        return getLoginUser() != null;
    }

    /**
     * 获取config.properties配置文件
     *
     * @param key
     * @return
     */
    public static String getConfig(String key) {
        return JConfig.getConfig(key);
    }

    /**
     * 中文乱码解码
     *
     * @param key
     * @return
     */
    public static String urlDecode(String key) {
        try {
            key = new String(key.getBytes("iso8859-1"), "utf-8");
        } catch (Exception e) {
        }
        return key;
    }

    /**
     * 时间格式化
     *
     * @param date
     * @return
     */
    public static String relativeDate(Date date) {
        return DateUtils.toDateTime(date);
    }

}
