package com.noself.utils;

public class StringTools {
    public static Boolean isEmpty(String str) {
        if(str == null || str.trim().equals("") || str.equals("null")) {
            return true;
        }else {
            return false;
        }
    }
}
