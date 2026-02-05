package com.anthropos.demo;

import com.anthropos.core.AnthroposVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;

public class TestVerticle2 extends AnthroposVerticle {



    @Override
    protected void handleMessage(Message<Object> message, Handler<String> handler) {
        System.out.println("TestVerticle2 received message: " + message.body());
        handler.handle("Cmm noi it thoi");
    }

    @Override
    protected String getName() {
        return TestVerticle2.class.getSimpleName();
    }
}
