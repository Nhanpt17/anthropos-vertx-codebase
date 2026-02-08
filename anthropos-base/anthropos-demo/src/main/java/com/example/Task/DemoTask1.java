package com.example.Task;

import com.anthropos.core.AnthroposMessage;
import com.anthropos.core.AnthroposTask;
import io.vertx.core.Handler;

public class DemoTask1 extends AnthroposTask {
    public DemoTask1() {
        super(DemoTask1.class.getSimpleName());
    }

    @Override
    protected void onStart(AnthroposMessage message, Handler<AnthroposMessage> handler) {
        System.out.println("Task1 is running...");
        handler.handle(message);
    }
}
