package com.jing.hang.utils;

public final class StringUtil {
    public static final String handRequestParams(String param) {
        int begin = param.indexOf("(");
        param = param.substring(begin + 1);
        param = param.replace(")", "");
        param = param.replace("id=null,", "");
        return param.replace("=null", "");
    }


}
