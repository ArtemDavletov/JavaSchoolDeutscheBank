package com.db.labs.reflection;

/**
 * @author Evgeny Borisov
 */
public interface Config {
    <T> Class<T> getImplClass(Class<T> type);
}
