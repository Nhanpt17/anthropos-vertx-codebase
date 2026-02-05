package com.anthropos;

import com.anthropos.demo.Burger;
import com.anthropos.demo.Food;
import com.anthropos.demo.task.Pizza;
import com.google.inject.AbstractModule;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class AnthroposModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Food.class).to(Burger.class);

        bind(Food.class).annotatedWith(Names.named("pizza")).to(Pizza.class);
    }
}
