package me.liumingbo.designPattern.strategyPattern.annotation;

import java.lang.annotation.*;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Strategy {
    String name() default "";
}
