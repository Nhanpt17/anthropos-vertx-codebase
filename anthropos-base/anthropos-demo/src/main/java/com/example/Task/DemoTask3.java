package com.example.Task;

import com.anthropos.core.AnthroposMessage;
import com.anthropos.core.AnthroposTask;
import io.vertx.core.Handler;

public class DemoTask3 extends AnthroposTask {
    public DemoTask3() {
        super(DemoTask3.class.getSimpleName());
    }

    @Override
    protected void onStart(AnthroposMessage message, Handler<AnthroposMessage> handler) {
        System.out.println("Task3 is running...");
        handler.handle(message);
    }
}
