package cc.cicadabear.common;

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
    private String error_code;
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
        this.error_code = code;
        this.msg = msg;
        this.ret = ret;
        this.data = data;
    }

    public ResultVo() {
        super();
    }

    public String getError_code() {
        return error_code;
    }

    public void setErrorCode(String errorCode) {
        this.error_code = errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.error_code = String.valueOf(errorCode);
    }

//    public String getErrorCode() {
//        return this.error_code;
//    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
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
