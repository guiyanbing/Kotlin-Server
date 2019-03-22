package com.module.user.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmsCodeUtils {
    public static String generateSmsCode() {
        String[] beforeShuffle = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
 
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        return afterShuffle.substring(5, 9);
    }
}

