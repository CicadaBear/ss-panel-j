package cc.cicadabear.domain.entity;


import cc.cicadabear.common.util.DateUtils;
import cc.cicadabear.domain.shared.GuidGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Shengzhao Li
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 913921286328215144L;
    /**
     * Database id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected int id;


    public AbstractEntity() {
    }

    public int id() {
        return id;
    }

    public void id(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNewly() {
        return id == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractEntity)) {
            return false;
        }
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id();
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(id).hashCode();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{id=").append(id);
//        sb.append(", archived=").append(archived);
//        sb.append(", version=").append(version);
//        sb.append(", guid='").append(guid).append('\'');
//        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}