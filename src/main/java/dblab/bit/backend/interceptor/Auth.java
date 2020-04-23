package dblab.bit.backend.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: backend
 * @description: auth annotation
 * @author: lihuichao
 * @create: 2020-04-23
 **/

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface Auth {
    boolean required() default true;
}
