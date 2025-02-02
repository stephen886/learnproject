package com.learn.core.utils;

import cn.hutool.core.bean.DynaBean;
import cn.hutool.core.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ObjectUtils
 * @Description 对象工具类
 * @Author dajie
 * @Date 2021/5/18 3:48 下午
 * @Version V1.0
 **/
public class ObjectUtils extends ObjectUtil {

    public static <T> List<T> convertIdToObject(List<String> ids, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        for (String id : ids) {
            DynaBean dynaBean = new DynaBean(clazz);
            dynaBean.set("id", id);
            list.add(dynaBean.getBean());
        }
        return list;
    }

}
