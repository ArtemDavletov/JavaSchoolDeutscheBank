package com.db.labs.reflection;

import com.db.labs.reflection.annotations.InjectByType;
import com.db.labs.reflection.annotations.InjectRandomInt;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator{
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();

        for (Field field : type.getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                field.set(t, field.getClass().getConstructor().newInstance());
            }
        }

    }
}
