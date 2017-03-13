package cc.cicadabear.service.impl;

import cc.cicadabear.common.config.JConfig;
import cc.cicadabear.common.util.BandwidthUtils;
import cc.cicadabear.common.util.DateUtils;
import cc.cicadabear.common.util.ThreadLocalHolder;
import cc.cicadabear.domain.dto.user.UserDto;
import cc.cicadabear.domain.dto.user.UserFormDto;
import cc.cicadabear.domain.dto.user.UserListDto;
import cc.cicadabear.domain.dto.user.UserRegisterDto;
import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.domain.repository.InviteCodeRepository;
import cc.cicadabear.domain.repository.UserRepository;
import cc.cicadabear.domain.shared.paginated.PaginatedLoader;
import cc.cicadabear.domain.shared.security.SecurityUserDetails;
import cc.cicadabear.service.InviteCodeService;
import cc.cicadabear.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shengzhao Li
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InviteCodeService inviteCodeService;

    @Autowired
    private InviteCodeRepository inviteCodeRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found any user for username[" + username + "]");
        }
        return new SecurityUserDetails(user);
    }


    @Override
    public UserListDto loadUserListDto(final UserListDto listDto) {
        final Map<String, Object> map = listDto.queryMap();
        return listDto.load(new PaginatedLoader<UserDto>() {
            @Override
            public List<UserDto> loadList() {
                List<User> users = userRepository.findListUsers(map);
                listDto.setUserList(users);
                return UserDto.toDtos(users);
            }

            @Override
            public int loadTotalSize() {
                return userRepository.totalListUsers(map);
            }
        });
    }

    @Override
    public UserFormDto loadUserFormDto(int id) {
        if (0 == id) {
            return new UserFormDto();
        } else {
            return new UserFormDto(userRepository.findById(id, User.class));
        }
    }

    @Override
    public User loadUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public User loadUserByID(int id) {
        return userRepository.findById(id, User.class);
    }

    @Override
    public int loadCount() {
        return userRepository.findCount();
    }

    @Override
    public boolean isExistUsername(String username) {
        User user = userRepository.findByUsernameIgnoreArchived(username);
        return user != null;
    }

    @Override
    public boolean isExistEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }


    @Override
    public void deleteUser(int id) {
        User user = userRepository.findById(id, User.class);
//        user.deleteMe();
        userRepository.delete(user);
    }

    @Override
    public void saveOrUpdate(User user) {
        userRepository.saveOrUpdate(user);
    }

    @Override
    public void registerUser(UserRegisterDto registerDto) {
        User user = registerDto.toEntity();
        InviteCode inviteCode = inviteCodeService.loadCodeByNo(registerDto.getCode());
        user.setInviter(inviteCode.getCreator());
        user.setPort(userRepository.findLastPort() + 1);
        user.setEnable(true);
        user.setIsAdmin(false);
        user.setPass(RandomStringUtils.randomAlphanumeric(6));
        user.setTransferEnable(BandwidthUtils.toGB(JConfig.getInteger("defaultTraffic")));
        user.setInviteNum(JConfig.getInteger("inviteNum"));
        user.setRegIp(ThreadLocalHolder.clientIp());
        user.setRegDate(DateUtils.now());
        saveOrUpdate(user);
        inviteCodeRepository.delete(inviteCodeService.loadCodeByNo(registerDto.getCode()));
    }


    @SuppressWarnings("deprecation")
    public void authenticate(String username, String rawPassword) throws Exception {

//        Validate.notNull(user, "User cannot be null");

//        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        GrantedAuthority role = new GrantedAuthorityImpl("AUTH_USER");//required to login
//        authorities.add(role);

//        GrantedAuthority auth = new GrantedAuthorityImpl("ROLE_USER");
//        authorities.add(auth);
//        Authentication authenticationToken =
//                new UsernamePasswordAuthenticationToken(username, rawPassword, authorities);
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, rawPassword);

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public List<User> loadAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", 0);
        map.put("perPageSize", 10);
        return userRepository.findListUsers(map);
//        return userRepository.findAll(User.class);
    }


}