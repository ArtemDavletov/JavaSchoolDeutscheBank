package com.db.labs.reflection;

import com.db.labs.reflection.annotations.InjectByType;
import com.db.labs.reflection.annotations.InjectRandomInt;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();

        for (Field field : type.getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotator = field.getAnnotation(InjectRandomInt.class);
                Random random = new Random();
                field.setAccessible(true);
                field.setInt(t, random.nextInt(annotator.max() - annotator.min()) + annotator.min());
            }
        }

    }
}
