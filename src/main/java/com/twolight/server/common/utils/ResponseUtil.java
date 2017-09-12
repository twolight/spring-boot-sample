package com.twolight.server.common.utils;

import com.twolight.server.response.Response;

public class ResponseUtil {

    public static Response error() {
        Response response = new Response<>();
        response.setCode(-1);
        response.setMessage("failed");

        return response;
    }

    public static Response invalidToken() {
        Response response = new Response();
        response.setCode(401);
        response.setMessage("token失效");
        return response;
    }

    public static <T> Response<T> success(T t) {
        Response<T> response = new Response<>();
        response.setCode(200);
        response.setMessage("success");
        response.setData(t);

        return response;
    }

    public static Response success() {
        Response response = new Response();
        response.setCode(200);
        response.setMessage("success");
        return response;
    }
}
