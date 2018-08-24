package com.jxd.mvc.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
@Transactional
public @interface ServiceTransaction {

    @AliasFor(annotation = Service.class)
    String value() default "";

    @AliasFor(annotation = Transactional.class)
    String transactionManager() default "";

}
