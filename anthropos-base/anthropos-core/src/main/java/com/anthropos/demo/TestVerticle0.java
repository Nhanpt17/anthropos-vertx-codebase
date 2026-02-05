package com.anthropos.demo;

import com.anthropos.core.AnthroposVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;

public class TestVerticle0 extends AnthroposVerticle {


    @Override
    protected void handleMessage(Message<Object> message, Handler<String> handler) {
        System.out.println("TestVerticle0 received message: " + message.body());
        handler.handle("TestVerticle0 reply!");
    }

    @Override
    protected String getName() {
        return TestVerticle0.class.getSimpleName();
    }

    protected Future<Void> initAction() {
        Promise<Void> promise = Promise.promise();

         vertx.setTimer(5000,id ->{
            vertx.eventBus().request(TestVerticle1.class.getSimpleName(), "TestVerticle0 publish message!")
                    .onSuccess(message -> System.out.println("TestVerticle0 received reply: " + message.body()))
                    .onFailure(err -> err.printStackTrace());
            promise.complete();
        } );
         return promise.future();
    }
}
