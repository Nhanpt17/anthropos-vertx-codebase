package com.anthropos.core;

import io.vertx.core.Handler;

public abstract class AnthroposTask {

    private final String taskName;

    protected AnthroposTask(String taskName) {
        this.taskName = taskName;
    }

    public final void start(AnthroposMessage message, Handler<AnthroposMessage> handler) {
        System.out.println("Start task: " + taskName);
        onStart(message, handler);
    }

    protected abstract void onStart(AnthroposMessage message, Handler<AnthroposMessage> handler);

}
