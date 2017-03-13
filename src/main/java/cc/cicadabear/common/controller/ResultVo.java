package cc.cicadabear.common.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * rest接口返回数据对象
 */
public class ResultVo {
    /**
     * 结果0-失败，1-成功
     */
    private int ret;
    /**
     * 结果代码
     */
    private String errorCode = "200";
    /**
     * 结果消息
     */
    private String msg;
    /**
     * 结果数据
     */
    private Object data;

    public static final int SUCCESS = 1;
    public static final int FAILURE = 0;

    public ResultVo(int ret, String code, String msg, Object data) {
        super();
        this.errorCode = code;
        this.msg = msg;
        this.ret = ret;
        this.data = data;
    }

    public ResultVo() {
        super();
    }

    @JsonProperty("error_code")
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = String.valueOf(errorCode);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void fail() {
        setRet(FAILURE);
    }

    public void success() {
        setRet(SUCCESS);
    }

    public void fail(String msg) {
        fail();
        setMsg(msg);
    }

    public void success(String msg) {
        success();
        setMsg(msg);
    }
}
