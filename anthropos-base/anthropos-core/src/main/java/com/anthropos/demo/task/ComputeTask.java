package com.anthropos.demo.task;

import com.anthropos.core.AnthroposMessage;
import com.anthropos.core.AnthroposTask;
import io.vertx.core.Handler;

public class ComputeTask extends AnthroposTask {
    protected ComputeTask(String taskName) {
        super(taskName);
        System.out.println("Create ComputeTask: " + taskName);
    }

    public ComputeTask(){
        this(ComputeTask.class.getSimpleName());
        System.out.println("Create ComputeTask");
    }

    @Override
    protected void onStart(AnthroposMessage message, Handler<AnthroposMessage> handler) {
        message.setContent(message.getContent() + " + 1");
        System.out.println("ComputeTask: " + message.getContent());
        handler.handle(message);
    }
}
