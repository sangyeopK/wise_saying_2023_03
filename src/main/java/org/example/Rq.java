package org.example;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode;
    private Map<String, String> params;

    Rq(String commend) {
        String[] commendBits = commend.split("\\?", 2);
        actionCode = commendBits[0];
        if (commendBits.length == 1) return;
        String[] paramsBits = commendBits[1].split("&");

        params = new HashMap<>();

        for (String paramsStr : paramsBits) {
            String[] paramsStrBits = paramsStr.split("=", 2);
            if (paramsStrBits.length == 1) continue;

            String key = paramsStrBits[0];
            String value = paramsStrBits[1];

            params.put(key, value);
            System.out.println(key);
            System.out.println(value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParams(String name) {
        return params.get(name);
    }

    public int getIntParam(String name, int defaultValue) {
        try {
            return Integer.parseInt(getParams(name));
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 값이 들어와서 에러가 발생");
        }
        return defaultValue;
    }
}