package com.spirit.cloudpos.common.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Gson Util클래스
 * @author changwoo.son
 */
public class GsonUtil {

    /**
     * object를 json string으로 변환
     * @param object json string 변환하려는 객체
     * @return
     */
    public static String toJsonString(Object object) {
        return new Gson().toJson(object);
    }

    /**
     * @param jsonString json string
     * @param type 반환 타입
     * @return
     */
    public static<T> T fromJson(String jsonString, Class<T> type) {
        return new Gson().fromJson(jsonString, type);
    }
}
