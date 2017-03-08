package cc.cicadabear.domain.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jack on 3/8/17.
 */
@Entity
@Table(name = "ss_invite_code")
public class InviteCode extends AbstractEntity {

    @Column(name = "code")
    private String Code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
