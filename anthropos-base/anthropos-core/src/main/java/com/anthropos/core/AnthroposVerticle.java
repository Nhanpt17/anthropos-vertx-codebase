package com.anthropos.core;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.VerticleBase;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;

public abstract class AnthroposVerticle extends VerticleBase {

    @Override
    public Future<?> start()  {
        EventBus eventBus = vertx.eventBus();
        eventBus.consumer(getName(), message -> {
            handleMessage(message, result -> message.reply(result));
        });
        initAction();
        System.out.println(getName() + " started");
        return Future.succeededFuture();
    }

    protected Future<Void> initAction() {
        return Future.succeededFuture();
    }

    // subclass must override this method to handle message
    protected abstract void handleMessage(Message<Object> message, Handler<String> handler);

    // subclass must override this method and provide a unique address
    protected abstract String getName();
}
