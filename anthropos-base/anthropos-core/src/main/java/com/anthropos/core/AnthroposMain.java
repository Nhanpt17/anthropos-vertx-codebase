package com.anthropos.core;

import io.vertx.launcher.application.VertxApplication;
import io.vertx.launcher.application.VertxApplicationHooks;

public class AnthroposMain extends VertxApplication {
    public AnthroposMain(String[] args) {
        super(args);
    }

    public AnthroposMain(String[] args, VertxApplicationHooks hooks) {
        super(args, hooks);
    }

    protected AnthroposMain(String[] args, VertxApplicationHooks hooks, boolean printUsageOnFailure, boolean exitOnFailure) {
        super(args, hooks, printUsageOnFailure, exitOnFailure);
    }


}
