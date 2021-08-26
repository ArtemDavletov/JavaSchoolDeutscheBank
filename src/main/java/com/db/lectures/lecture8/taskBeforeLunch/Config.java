package com.db.lectures.lecture8.taskBeforeLunch;

import com.sun.jdi.InterfaceType;

import java.util.HashMap;
import java.util.Map;

public interface Config {
    public <T> Class<T> getImplClass(Class<T> type);
}
