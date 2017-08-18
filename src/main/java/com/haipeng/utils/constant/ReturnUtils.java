package com.haipeng.utils.constant;

import com.haipeng.bussiness.data.model.response.ReturnResult;

public class ReturnUtils {

    public static ReturnResult getResutlt(String msg,String code){
        ReturnResult rr = new ReturnResult();
        rr.setMsg(msg);
        rr.setCode(code);
        return rr;
    }
}
