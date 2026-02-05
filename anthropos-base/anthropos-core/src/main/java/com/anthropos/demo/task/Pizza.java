package com.anthropos.demo.task;

import com.anthropos.demo.Food;

public class Pizza implements Food {


    @Override
    public void smell() {
        System.out.println("pizza smells like cheese");
    }
}
