package cc.cicadabear.web.context;

import cc.cicadabear.domain.shared.security.SecurityHolder;
import cc.cicadabear.domain.shared.security.SecurityUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Shengzhao Li
 */
public class SpringSecurityHolder implements SecurityHolder {

    @Override
    public SecurityUserDetails userDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof SecurityUserDetails) {
            return (SecurityUserDetails) principal;
        }
        return null;
    }
}