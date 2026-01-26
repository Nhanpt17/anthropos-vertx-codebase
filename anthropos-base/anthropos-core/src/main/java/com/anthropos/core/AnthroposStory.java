package com.anthropos.core;

import io.vertx.core.Handler;

public class AnthroposStory extends AnthroposEpic {

    protected AnthroposStory(String taskName) {
        super(taskName);
    }

    @Override
    protected void onStart(AnthroposMessage message, Handler<AnthroposMessage> handler) {
        devideTask(message, handler);
    }

    private void devideTask(AnthroposMessage message, Handler<AnthroposMessage> handler) {
        execute(message, handler, 0);
    }

    private void execute(AnthroposMessage message, Handler<AnthroposMessage> handler, int index) {

        if (tasks.size() == index || message.isStop()) {
            handler.handle(message);
        } else {
            AnthroposTask task = tasks.get(index);
            task.start(message, anthroposMessage -> {
                System.out.println("Message: " + anthroposMessage.toString());
                execute(anthroposMessage, handler, index + 1);
            });
        }

    }

}
