package cc.cicadabear.domain.entity;

import cc.cicadabear.common.util.DateUtils;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Jack on 3/11/17.
 */
@Entity
@Table(name = "ss_node")
public class Node extends AbstractEntity {
    public static final LinkedHashMap<String, String> METHODS = new LinkedHashMap<String, String>();

    public static final List<String> METHODS_LIST = new ArrayList<String>();

    static {
//        METHODS.put("rc4-md5","rc4-md5");
        METHODS_LIST.add("rc4-md5");
        METHODS_LIST.add("aes-128-cfb");
        METHODS_LIST.add("aes-192-cfb");
        METHODS_LIST.add("aes-256-cfb");
        METHODS_LIST.add("des-cfb");
        METHODS_LIST.add("bf-cfb");
        METHODS_LIST.add("cast5-cfb");
        METHODS_LIST.add("chacha20");
        METHODS_LIST.add("salsa20");
    }

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private int type = 1;

    @Column(name = "server")
    private String server = "127.0.0.1";

    @Column(name = "method")
    private String method = "aes-256-cfb";

    @Column(name = "custom_method", columnDefinition = "tinyint(1)")
    private boolean customMethod;

    @Column(name = "traffic_rate")
    private float trafficRate = 1;

    @Column(name = "info")
    private String info = "";

    @Column(name = "status")
    private String status = "";

    @Column(name = "offset")
    private int offset = 0;

    @Column(name = "sort")
    private int sort = 0;


    public static LinkedHashMap<String, String> getMETHODS() {
        return METHODS;
    }

    public static List<String> getMethodsList() {
        return METHODS_LIST;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isCustomMethod() {
        return customMethod;
    }

    public void setCustomMethod(boolean customMethod) {
        this.customMethod = customMethod;
    }

    public float getTrafficRate() {
        return trafficRate;
    }

    public void setTrafficRate(float trafficRate) {
        this.trafficRate = trafficRate;
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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getNodeLoad() {
        return "暂未开通";
    }

    public int getOnlineUserCount() {
        return 0;
    }

    public String getTrafficFromLogs() {
        return "0MB";
    }

    public String getNodeUptime() {
        return DateUtils.toDateTime(DateUtils.now());
    }

}
