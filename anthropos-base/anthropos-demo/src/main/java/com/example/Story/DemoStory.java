package com.example.Story;

import com.anthropos.core.AnthroposEpic;
import com.anthropos.core.AnthroposMessage;
import com.anthropos.core.AnthroposStory;
import com.example.Task.DemoTask1;
import com.example.Task.DemoTask2;
import com.example.Task.DemoTask3;
import io.vertx.core.Handler;

public class DemoStory extends AnthroposStory {
    public DemoStory() {
        super(DemoStory.class.getSimpleName());
        tasks.add(new DemoTask1());
        tasks.add(new DemoTask2());
        tasks.add(new DemoTask3());
    }


}
