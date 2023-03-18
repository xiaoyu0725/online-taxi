package com.lhy.internalcommon.util;

public class SsePrefixUtils {

    public static final String sperator = "$";

    public  static String generatorSseKey(int userId , String identity){
        return userId+sperator+identity;
    }
}
