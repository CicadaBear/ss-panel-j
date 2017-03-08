package cc.cicadabear.domain.dto;

import java.io.Serializable;

/**
 * @author Shengzhao Li
 */
@SuppressWarnings("serial")
public abstract class AbstractDto implements Serializable {

    protected int id;

    protected AbstractDto() {
    }

    protected AbstractDto(int id) {
        this.id = id;
    }

    public boolean isNewly() {
        return id == 0;
    }

    public int getId() {
        return id;
    }

    public void setGuid(int id) {
        this.id = id;
    }
}