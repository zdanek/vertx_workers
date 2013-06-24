package pl.touk.alarmy;

import org.vertx.java.core.json.JsonObject;
import org.vertx.java.core.json.impl.Json;
import org.vertx.java.deploy.Verticle;

/**
 * @author bzd
 */
public class FastIndexRest extends Verticle {

    @Override
    public void start() throws Exception {

        for (int i=0;i<100; i++) {
            System.out.print("Generuje i wysylam builda " + i + "...");
            Build build = new Build();
            build.setDisplayName("Build_" + i);
            vertx.eventBus().send(FastIndexWorker.WORKER_ADDRESS, new JsonObject(Json.encode(build)));
            System.out.println(" wyslano!");
        }
    }
}
