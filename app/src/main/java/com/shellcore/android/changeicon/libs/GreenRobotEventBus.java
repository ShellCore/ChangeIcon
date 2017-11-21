package com.shellcore.android.changeicon.libs;

import com.shellcore.android.changeicon.libs.base.EventBus;

/**
 * Created By MOGC on 05/09/2017.
 */

public class GreenRobotEventBus implements EventBus {

    private org.greenrobot.eventbus.EventBus eventBus;

    public GreenRobotEventBus(org.greenrobot.eventbus.EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
