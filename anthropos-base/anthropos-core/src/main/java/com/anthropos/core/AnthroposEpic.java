package com.anthropos.core;


import java.util.ArrayList;
import java.util.List;

public abstract class AnthroposEpic extends AnthroposTask {
    protected List<AnthroposTask> tasks = new ArrayList<>();

    public AnthroposEpic(String taskName) {
        super(taskName);
    }

    protected void addTask(AnthroposTask task){
        tasks.add(task);
    }



}
