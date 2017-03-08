package cc.cicadabear.service;

import cc.cicadabear.domain.dto.user.*;
import cc.cicadabear.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Shengzhao Li
 */
public interface UserService extends UserDetailsService {

    UserListDto loadUserListDto(UserListDto listDto);

    UserFormDto loadUserFormDto(int id);

    User loadUserByEmail(String email);

    User loadUserByID(int id);

    boolean isExistUsername(String username);

    boolean isExistEmail(String email);

    void deleteUser(int id);

    void saveOrUpdate(User user);

    void registerUser(UserRegisterDto registerDto);

    void authenticate(String username, String rawPassword) throws Exception;

}