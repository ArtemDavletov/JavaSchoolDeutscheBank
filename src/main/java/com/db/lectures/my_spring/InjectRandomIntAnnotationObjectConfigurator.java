package com.db.lectures.my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class InjectRandomIntAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        for (Field field : type.getDeclaredFields()) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if(annotation!=null){
                int max = annotation.max();
                int min = annotation.min();
                Random random = new Random();
                field.setAccessible(true);
                field.setInt(t, random.nextInt(max - min) + min);
            }
        }

    }
}
