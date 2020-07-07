package com.nostalgia.phone_store_backend.exception;

import com.nostalgia.phone_store_backend.enums.ResultEnum;

public class MyException extends RuntimeException{
    public MyException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
    }
}
