package com.neaghfoz.framework.base;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-6-21
 * Time: 上午9:29
 * 抛出异常的信息
 */
public class BaseException extends Exception {

    private String errorMsg;

    public BaseException() {
        super();
    }

    public BaseException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public BaseException(String errorMsg, Throwable cause) {
        super(cause);
        this.errorMsg = errorMsg;
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
