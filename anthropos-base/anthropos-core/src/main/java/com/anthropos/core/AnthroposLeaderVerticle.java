package com.anthropos.core;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class AnthroposLeaderVerticle extends VerticleBase {

    @Override
    public Future<?> start() {
        vertx.eventBus().registerDefaultCodec(AnthroposMessage.class, new AnthroposCodec());
        return loadConfig().compose(result ->{
            if(result == null || result.isEmpty()){
                return Future.failedFuture("Load config failed");
            }
            JsonArray verticles = result.getJsonArray("verticles");
            if(verticles == null || verticles.isEmpty()){
                return Future.failedFuture("No verticles found");
            }
            return Future.succeededFuture(result);
        }).compose(result2 ->{
            JsonArray verticles = result2.getJsonArray("verticles");
            List<Future<String>> deployments = new ArrayList<>();
            DeploymentOptions options = new DeploymentOptions().setConfig(result2);

            verticles.forEach( veticle -> {
                Future<String> deployment = vertx.deployVerticle(veticle.toString(), options);
                deployments.add(deployment);
            });
            return Future.all(deployments);
        })
                .onSuccess(v -> System.out.println("All verticles deployed"))
                .onFailure(err -> System.out.println("Failed to deploy verticles: " + err.getMessage()));
    }

    private Future<JsonObject> loadConfig() {
        ConfigStoreOptions fileStore = new ConfigStoreOptions()
                .setType("file")
                .setConfig(new JsonObject().put("path", "config.json"));

        ConfigRetrieverOptions options = new ConfigRetrieverOptions()
                .addStore(fileStore);

        ConfigRetriever retriever =  ConfigRetriever.create(vertx, options);
        return retriever.getConfig()
                .onSuccess(config -> System.out.println("Config loaded: " + config.encodePrettily()))
                .onFailure(err -> System.out.println("Failed to load config: " + err.getMessage()));
    }


}
