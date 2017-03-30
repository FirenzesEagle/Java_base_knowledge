package me.liumingbo.designPattern.simpleFactoryPattern.annotation;

import java.lang.annotation.*;

/**
 * Created by FirenzesEagle on 2017/3/30.
 * Email:liumingbo2008@gmail.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Vehicle {
    String type() default "";
}
