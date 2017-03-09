package cc.cicadabear.domain.shared.security;

import cc.cicadabear.domain.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Shengzhao Li
 */
public class SecurityUserDetails implements UserDetails {

    protected static final String ROLE_PREFIX = "ROLE_";

    protected User user;

    protected List<GrantedAuthority> authorities = new ArrayList<>();

    public SecurityUserDetails() {
    }

    public SecurityUserDetails(User user) {
        this.user = user;
        initialPrivileges();
    }

    private void initialPrivileges() {
        this.authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + "USER"));
        if (user.isAdmin()) {
            this.authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + "ADMIN"));
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.password();
    }

    @Override
    public String getUsername() {
        return user.email();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User user() {
        return user;
    }

//    public String getLastLoginTime() {
//        if (user != null && user.lastLoginTime() != null) {
//            return DateUtils.toDateText(user.lastLoginTime(), DateUtils.DEFAULT_DATE_TIME_FORMAT);
//        }
//        return "---";
//    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}