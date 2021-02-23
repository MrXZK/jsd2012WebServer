package com.webserver.http;

/**
 * 空请求异常
 * 当HttpRequest解析请求时发现此请求为空请求则会抛出该异常
 */
public class EmptyRequestException extends Exception{
    /* 重写异常超类中的抽象方法 */
    public EmptyRequestException() {
    }

    /* 重写异常超类中的抽象方法 */
    public EmptyRequestException(String message) {
        super(message);
    }

    /* 重写异常超类中的抽象方法 */
    public EmptyRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    /* 重写异常超类中的抽象方法 */
    public EmptyRequestException(Throwable cause) {
        super(cause);
    }

    /* 重写异常超类中的抽象方法 */
    public EmptyRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
