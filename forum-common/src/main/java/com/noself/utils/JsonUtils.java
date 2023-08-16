package com.noself.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonUtils {

    /**
     * JSON转字符串
     *
     * @param obj
     * @return
     */
    public static String covertObj2String(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * json字符串转对象
     * @param str
     * @param classz
     * @return
     * @param <T>
     */
    public static <T> T covertJson2Obj(String str, Class<T> classz) {
        return JSONObject.parseObject(str, classz);
    }

    /**
     * json字符串转对象列表
     * @param str
     * @param classz
     * @return
     * @param <T>
     */
    public static <T> List<T> covertJsonArray2List(String str, Class<T> classz) {
        return JSONArray.parseArray(str, classz);
    }
}
