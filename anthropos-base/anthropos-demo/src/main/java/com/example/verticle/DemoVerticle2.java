package com.example.verticle;

import com.anthropos.core.AnthroposMessage;
import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.internal.ContextInternal;

public class DemoVerticle2 extends VerticleBase {

    public Future<?> start() throws Exception {

        vertx.setTimer(10000, id -> {
            System.out.println("Timer 1000ms");
            AnthroposMessage message = new AnthroposMessage();
            message.setErrorDesc("Error from verticle 2");
            vertx.eventBus().send(DemoVerticle1.class.getSimpleName(), message);
        });

        return Future.succeededFuture();
    }

}
