package com.anthropos.demo.task;

import com.anthropos.core.AnthroposMessage;
import com.anthropos.core.AnthroposTask;
import io.vertx.core.Handler;

public class PrintTask extends AnthroposTask {
    protected PrintTask(String taskName) {
        super(taskName);
        System.out.println("Create PrintTask: " + taskName);

    }

    public PrintTask() {
        this(PrintTask.class.getSimpleName());
        System.out.println("Create PrintTask");
    }

    @Override
    protected void onStart(AnthroposMessage message, Handler<AnthroposMessage> handler) {
        System.out.println("PrintTask: " + message.getContent());
        handler.handle(message);
    }
}
