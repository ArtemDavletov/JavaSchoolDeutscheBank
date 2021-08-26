package com.db.labs.reflection.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Retention(RUNTIME)
@Target(FIELD)
public @interface InjectRandomInt {
    int min();
    int max();
}
