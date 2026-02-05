package com.anthropos.demo;

import io.vertx.launcher.application.VertxApplication;
import io.vertx.launcher.application.VertxApplicationHooks;

public class MainDemo extends VertxApplication {
    public MainDemo(String[] args) {
        super(args);
    }

    public MainDemo(String[] args, VertxApplicationHooks hooks) {
        super(args, hooks);
    }

    protected MainDemo(String[] args, VertxApplicationHooks hooks, boolean printUsageOnFailure, boolean exitOnFailure) {
        super(args, hooks, printUsageOnFailure, exitOnFailure);
    }
}
