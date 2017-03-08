package cc.cicadabear.common.util;


import cc.cicadabear.domain.entity.User;
import cc.cicadabear.domain.shared.security.SecurityHolder;
import cc.cicadabear.domain.shared.security.SecurityUserDetails;

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
        return userDetails != null ? userDetails.user() : null;
    }

    public static String currentUsername() {
        final User user = currentUser();
        return user != null ? user.username() : "unknown";
    }
}