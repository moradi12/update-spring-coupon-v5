package com.coupon.project.database.Exceptions;

public class CustomerException extends  Exception{
    public CustomerException(ErrMsg errMsg) {
        super(errMsg.getMsg());
    }

    public CustomerException(ErrMsg errMsg, Throwable cause) {
        super(errMsg.getMsg(), cause);
    }
}
