package com.kebo.springboot_jpa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @description:
 * @author: kb
 * @create: 2020-07-01 21:21
 **/
public class FieldIsNull {
    private static Logger logger= LoggerFactory.getLogger(FieldIsNull.class);
    public static boolean allFieldIsNULL(Object source, List<String> excludeNames) {
        boolean flag = true;
        try {
            // 取到obj的class, 并取到所有属性
            Field[] fs = source.getClass().getDeclaredFields();
            // 遍历所有属性
            for (Field f : fs) {
                // 设置私有属性也是可以访问的
                f.setAccessible(true);
                // 1.排除不包括的属性名, 2.属性值为空, 3.属性值转换成String为""
                if (null != excludeNames) {
                    if (!excludeNames.contains(f.getName())) {
                        if ((f.get(source) == null || "".equals(f.get(source).toString()))) {
                            flag = false;
                            break;
                        }
                    }
                } else {
                    if ((f.get(source) == null || "".equals(f.get(source).toString()))) {
                        flag = false;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("判断对象属性为空异常", e);
        }
        return flag;
    }
}

