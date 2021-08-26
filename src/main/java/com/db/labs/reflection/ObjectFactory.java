package com.db.labs.reflection;

import com.db.labs.reflection.annotations.InjectByType;
import com.db.labs.reflection.annotations.InjectRandomInt;
import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    @Getter
    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }

        T t = type.getDeclaredConstructor().newInstance();

        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotator = field.getAnnotation(InjectRandomInt.class);
                Random random = new Random();
                field.setInt(t, random.nextInt(annotator.max() - annotator.min()) + annotator.min());
            } else if (field.isAnnotationPresent(InjectByType.class)) {
                field.set(t, field.getClass().getConstructor().newInstance());
            }
        }

        return t;
    }




}
