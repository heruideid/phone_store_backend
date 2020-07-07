package com.nostalgia.phone_store_backend.util;

import com.nostalgia.phone_store_backend.vo.ResultVO;

public class ResultUtil {
    public static ResultVO success(Object data){
        return new ResultVO(0,"成功",data);
    }


}
