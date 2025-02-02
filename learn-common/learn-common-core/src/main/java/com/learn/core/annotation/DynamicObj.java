package com.learn.core.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;

/**
 * @ClassName DynamicObj
 * @Description
 * @Author dajie
 * @Date 2021/7/26 4:53 下午
 * @Version V1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {FIELD, ANNOTATION_TYPE})
public @interface DynamicObj {

    String name() default "";

    String dbRef() default "";

    boolean lazy() default false;

}
