package com.anthropos.demo.story;

import com.anthropos.demo.task.ComputeTask;
import com.anthropos.demo.task.PrintTask;
import com.anthropos.core.AnthroposStory;

public class NotiStory extends AnthroposStory {
    protected NotiStory(String taskName) {
        super(taskName);
        System.out.println("Create NotiStory: " + taskName);
    }

    public NotiStory(){
        this(NotiStory.class.getSimpleName());
        addTask(new PrintTask());
        addTask(new ComputeTask());
        System.out.println("Create NotiStory");
    }


}
