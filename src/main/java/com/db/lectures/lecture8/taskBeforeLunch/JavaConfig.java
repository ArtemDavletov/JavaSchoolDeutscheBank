package com.db.lectures.lecture8.taskBeforeLunch;

import java.util.HashMap;
import java.util.Map;

public class JavaConfig implements Config {
    private Map<Class, Class> interfaceToClass= new HashMap<>();

    public JavaConfig() {
        interfaceToClass.put(Config.class, JavaConfig.class);
    }

    @Override
    public <T> Class<T> getImplClass(Class<T> type) {
        return interfaceToClass.get(type);
    }
}
