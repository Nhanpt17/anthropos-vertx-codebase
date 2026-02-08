package com.anthropos.core;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.VerticleBase;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.eventbus.MessageConsumer;

public abstract class AnthroposVerticle extends VerticleBase {

    @Override
    public Future<?> start()  {
        Class<? extends  AnthroposVerticle> clazz = this.getClass();
        EventBus eventBus = vertx.eventBus();
        MessageConsumer<AnthroposMessage> consumer = eventBus.consumer(clazz.getSimpleName());
        consumer.handler(message -> {
            handleMessage(message);
        });
        initAction();
        System.out.println(clazz.getSimpleName()+ " started");
        return Future.succeededFuture();
    }

    protected void initAction() {
         // override this method to perform some initialization action
    }

    // subclass must override this method to handle message
    protected abstract void handleMessage(Message<AnthroposMessage> message);

}
