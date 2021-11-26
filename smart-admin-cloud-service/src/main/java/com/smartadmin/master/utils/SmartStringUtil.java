package com.smartadmin.master.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/23
 */
public class SmartStringUtil extends StringUtils {

    public static List<Long> splitConvertToLongList(String str, String split, long defaultVal) {
        if (isEmpty(str)) {
            return new ArrayList<Long>();
        }
        String[] strArr = str.split(split);
        List<Long> list = new ArrayList<Long>(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            try {
                long parseLong = Long.parseLong(strArr[i]);
                list.add(parseLong);
            } catch (NumberFormatException e) {
                list.add(defaultVal);
                continue;
            }
        }
        return list;
    }

    public static List<Long> splitConvertToLongList(String str, String split) {
        return splitConvertToLongList(str, split, 0L);
    }
}
