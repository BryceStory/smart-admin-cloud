package com.smartadmin.master.common.exception;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/23
 */
public class SmartBusinessException extends RuntimeException {
    private static final long serialVersionUID = 6471797988926341430L;

    public SmartBusinessException() {
    }

    public SmartBusinessException(String message) {
        super(message);
    }

    public SmartBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public SmartBusinessException(Throwable cause) {
        super(cause);
    }


    public SmartBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
