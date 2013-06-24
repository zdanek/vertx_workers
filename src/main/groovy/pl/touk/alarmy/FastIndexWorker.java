package pl.touk.alarmy;

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.deploy.Verticle;

/**
 * @author bzd
 */
public class FastIndexWorker extends Verticle {
    public static final String WORKER_ADDRESS = "worker.address";

    @Override
    public void start() throws Exception {

        System.out.println("WORKER START " + this.toString());

        vertx.eventBus().registerHandler(WORKER_ADDRESS, new Handler<Message>() {
            @Override
            public void handle(Message event) {
                Build build = Build.fromJson((JsonObject)event.body);
                System.out.println("Worker [" + (vertx.isWorker() ? "YES" : "NO") + "] Got build " + build.getDisplayName() + ". Working (going sleep)!");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });
    }
}
