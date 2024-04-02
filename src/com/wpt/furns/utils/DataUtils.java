package com.wpt.furns.utils;/**
 * @author wpt@onlying.cn
 * @date 2024/4/1 21:12
 */

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.utils
 * @className: DataUtils
 * @author: wpt
 * @description: TODO
 * @date: 2024/4/1 21:12
 * @version: 1.0
 */
public class DataUtils {
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String val, int defaultVal) {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            System.out.println(val+"格式不正确");
        }
        return defaultVal;
    }
}

