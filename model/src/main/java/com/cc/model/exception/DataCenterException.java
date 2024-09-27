package com.cc.model.exception;

import lombok.Data;

/**
 * 异常处理.
 */
@Data
public class DataCenterException extends RuntimeException{
    private Integer code = 500;

    public DataCenterException(String msg) {
        super(msg);
    }

    public DataCenterException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }
}
