package com.anthropos.core;

import io.vertx.core.Handler;

public class AnthroposStory extends AnthroposEpic {

    protected AnthroposStory(String taskName) {
        super(taskName);
    }

    @Override
    protected void onStart(AnthroposMessage message, Handler<AnthroposMessage> handler) {
        divideTask(message, handler);
    }

    private void divideTask(AnthroposMessage message, Handler<AnthroposMessage> handler) {
        execute(message, handler, 0);
    }

    private void execute(AnthroposMessage message, Handler<AnthroposMessage> handler, int index) {

        if (tasks.size() == index || !message.isProcess()) {
            handler.handle(message);
        } else {
            AnthroposTask task = tasks.get(index);
            task.start(message, anthroposMessage -> {
                execute(anthroposMessage, handler, index + 1);
            });
        }
    }

}
