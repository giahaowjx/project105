package com.example.project105.utils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public final class NetworkUtils {

    public static Map<String, RequestBody> generateRequestBodyMap(Map<String, String> data) {
        Map<String, RequestBody> requestBodyMap = new HashMap<>();
        for (String key : data.keySet()) {
            String body = data.get(key);
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), body);

            requestBodyMap.put(key, requestBody);

        }
        return requestBodyMap;
    }

    public static RequestBody generateRequestBody(String data) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), data);
    }

}
