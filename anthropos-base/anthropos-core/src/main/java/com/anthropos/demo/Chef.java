package com.anthropos.demo;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Chef {
    private Food food;

    @Inject
    public Chef(Food food){
        this.food = food;
    }

    public void cook(){
        food.smell();
    }
}
