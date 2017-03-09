package cc.cicadabear.common.util;


import cc.cicadabear.domain.entity.User;
import cc.cicadabear.domain.shared.security.SecurityHolder;
import cc.cicadabear.domain.shared.security.SecurityUserDetails;
import cc.cicadabear.service.UserService;

/**
 * @author Shengzhao Li
 */
public class SecurityUtils {

    private static SecurityHolder securityHolder;

    public void setSecurityHolder(SecurityHolder securityHolder) {
        SecurityUtils.securityHolder = securityHolder;
    }

    public static User currentUser() {
        SecurityUserDetails userDetails = securityHolder.userDetails();
        if (userDetails != null) {
            if (!ThreadLocalHolder.getSession().contains(userDetails.user())) {
                UserService userService = ThreadLocalHolder.getApplicationContext().getBean(UserService.class);
                userDetails.setUser(userService.loadUserByID(userDetails.user().id()));
            }
            return userDetails.user();
        } else {
            return null;
        }
    }

    public static void setUser(User user) {
        SecurityUserDetails userDetails = securityHolder.userDetails();
        userDetails.setUser(user);
    }

    public static boolean isLogin() {
        return currentUser() == null;
    }

    public static String currentUsername() {
        final User user = currentUser();
        return user != null ? user.username() : "unknown";
    }
}