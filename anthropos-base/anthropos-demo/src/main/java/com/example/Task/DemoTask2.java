package com.example.Task;

import com.anthropos.core.AnthroposMessage;
import com.anthropos.core.AnthroposTask;
import io.vertx.core.Handler;

public class DemoTask2 extends AnthroposTask {
    public DemoTask2() {
        super(DemoTask2.class.getSimpleName());
    }

    @Override
    protected void onStart(AnthroposMessage message, Handler<AnthroposMessage> handler) {
        System.out.println("Task2 is running...");
        handler.handle(message);
    }
}
