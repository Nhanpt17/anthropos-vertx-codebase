package com.anthropos.demo;

import com.anthropos.core.AnthroposVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;

public class TestVerticle1 extends AnthroposVerticle {




    @Override
    protected void handleMessage(Message<Object> message, Handler<String> handler) {
        System.out.println("TestVerticle1 received message: " + message.body());
        handler.handle("Khu 2 hoang thuong thanh 3 phu tho");
        vertx.eventBus().request(TestVerticle2.class.getSimpleName(), "TestVerticle1 request message!")
                .onSuccess(message1 -> System.out.println("TestVerticle1 received reply: " + message1.body()))
                .onFailure(err -> err.printStackTrace());
    }

    @Override
    protected String getName() {
        return TestVerticle1.class.getSimpleName();
    }
}
