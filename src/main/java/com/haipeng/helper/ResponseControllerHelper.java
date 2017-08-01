package com.haipeng.helper;

import com.google.gson.JsonObject;
import com.haipeng.customer.User;

public class ResponseControllerHelper {


    public static String success(JsonObject jsonObject) {
        String str = "{'code'='200'";
        str = str + "'data'=" + jsonObject + "}";

        return str;
    }

    public static String success(String data) {
        String str = "{'code'='200'";
        str = str + "'data'=" + data + "}";

        return str;
    }

    public static String fail(String msg) {
        String str = "{'code'='403'";
        str = str + "'msg'=" + msg + "}";

        return str;
    }

}
