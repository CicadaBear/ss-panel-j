package cc.cicadabear.domain.dto.user;


import cc.cicadabear.common.config.JConfig;
import cc.cicadabear.domain.entity.User;
import cc.cicadabear.domain.shared.paginated.DefaultPaginated;

import java.util.List;
import java.util.Map;

/**
 * @author Shengzhao Li
 */
public class UserListDto extends DefaultPaginated<UserDto> {

    private List<User> userList;

    private String username;



    public UserListDto() {
    }

    @Override
    public Map<String, Object> queryMap() {
        final Map<String, Object> map = super.queryMap();
        map.put("username", username);
        return map;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}