package cc.cicadabear.domain.dto.user;

import cc.cicadabear.domain.dto.AbstractDto;
import cc.cicadabear.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shengzhao Li
 */
public class UserDto extends AbstractDto {

    private static final long serialVersionUID = -2716743335497591940L;
    protected String username;
    protected String createDate;

    protected String email;

    public UserDto() {
    }

    public UserDto(User user) {
        super(user.id());
        this.username = user.username();

        this.email = user.email();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<UserDto> toDtos(List<User> users) {
        List<UserDto> dtoList = new ArrayList<>(users.size());
        for (User user : users) {
            dtoList.add(new UserDto(user));
        }
        return dtoList;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("UserDto");
        sb.append("{username='").append(username).append('\'');
        sb.append(", createDate='").append(createDate).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}