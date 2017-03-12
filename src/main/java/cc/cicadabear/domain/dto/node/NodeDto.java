package cc.cicadabear.domain.dto.node;

import cc.cicadabear.domain.dto.AbstractDto;
import cc.cicadabear.domain.entity.Node;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Jack on 3/11/17.
 */
public class NodeDto extends AbstractDto {

    private String name;

    private String server = "127.0.0.1";

    private String method = "aes-256-cfb";

    private int customMethod = 0;

    private float rate = 1;

    private String info;

    private int type = 1;

    private String status;

    private int sort = 0;

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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getCustomMethod() {
        return customMethod;
    }

    public void setCustom_method(int customMethod) {
        this.customMethod = customMethod;
    }

    public void setCustomMethod(int customMethod) {
        this.customMethod = customMethod;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
//    public void setSort(String sort) {
//        if (StringUtils.isNotEmpty(sort)) {
//            this.sort = Integer.valueOf(sort);
//        }
//    }
    //    $node->name = $request->getParam('name');
//    $node->server = $request->getParam('server');
//    $node->method = $request->getParam('method');
//    $node->custom_method = $request->getParam('custom_method');
//    $node->traffic_rate = $request->getParam('rate');
//    $node->info = $request->getParam('info');
//    $node->type = $request->getParam('type');
//    $node->status = $request->getParam('status');
//    $node->sort = $request->getParam('sort');

    public Node toEntity() {
        Node node = new Node();
        node.setName(name);
        node.setServer(server);
        node.setMethod(method);
        node.setTrafficRate(rate);
        node.setCustomMethod(customMethod == 1);
        node.setSort(sort);
        node.setType(type);
        node.setInfo(info);
        node.setStatus(status);
        return node;
    }
}
