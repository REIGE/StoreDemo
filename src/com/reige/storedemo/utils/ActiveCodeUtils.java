package com.reige.storedemo.utils;

import java.util.UUID;

/**
 * Created by REIGE on 2017/7/6.
 */
public class ActiveCodeUtils {

    public static String getActiveCode() {
        return UUID.randomUUID().toString()+UUID.randomUUID().toString();
    }
}
