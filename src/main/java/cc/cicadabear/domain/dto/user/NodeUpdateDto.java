package cc.cicadabear.domain.dto.user;


import cc.cicadabear.domain.dto.AbstractDto;
import cc.cicadabear.domain.entity.Node;
import cc.cicadabear.domain.entity.User;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Shengzhao Li
 */
public class NodeUpdateDto extends AbstractDto {

    private String name;
    private String server;
    private float rate;
    private String method;
    private String info;
    private String status;
    private int sort;
    private int type;
    private int custom_method;

    private Node node;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCustom_method() {
        return custom_method;
    }

    public int getCustomMethod() {
        return custom_method;
    }

    public void setCustom_method(int custom_method) {
        this.custom_method = custom_method;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}