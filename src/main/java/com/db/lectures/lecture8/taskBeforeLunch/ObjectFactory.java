package com.db.lectures.lecture8.taskBeforeLunch;

import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class ObjectFactory {

    private static volatile ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();

    @SneakyThrows
    public <T> T createObject(Class<T> classOrInterface) {
        if (!classOrInterface.isInterface()) {
            return classOrInterface.getConstructor().newInstance();
        }
        return config.getImplClass(classOrInterface).getConstructor().newInstance();
    }
}
