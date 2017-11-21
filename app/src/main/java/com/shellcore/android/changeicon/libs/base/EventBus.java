package com.shellcore.android.changeicon.libs.base;

/**
 * Created By MOGC on 05/09/2017.
 */

public interface EventBus {

    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
