package com.example.verticle;

import com.anthropos.core.AnthroposMessage;
import com.anthropos.core.AnthroposVerticle;
import com.example.Story.DemoStory;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;

public class DemoVerticle1 extends AnthroposVerticle {

    DemoStory story;

    @Override
    protected void handleMessage(Message<AnthroposMessage> message) {
        AnthroposMessage anthroposMessage = message.body();
        story.start(anthroposMessage, result -> message.reply(result));
    }

    protected void initAction() {
        story = new DemoStory();
    }
}
