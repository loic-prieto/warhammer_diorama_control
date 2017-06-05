package es.sephire.diorama.server.web;

import es.sephire.diorama.server.Loggable;
import es.sephire.diorama.server.config.ConfigurationProvider;
import spark.Service;
import static spark.Service.ignite;

/**
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public class WebServer implements Loggable {

    // Dependencies
    private ConfigurationProvider configuration;
    private Service server;

    public WebServer(ConfigurationProvider configuration, Service server){
        this.configuration = configuration;
        this.server = server;

        server.port(configuration.getInt(ConfigurationKeys.port.getKey()));
        setupRoutes();
    }
    public WebServer(ConfigurationProvider configuration) {
       this(configuration,ignite());
    }

    public void start(){
        logger().info("Starting the web server...");
        server.init();
        server.awaitInitialization();
        logger().info("Web server started");
    }

    public void stop() {
        logger().info("Stopping the web server...");
        server.stop();
        logger().info("Web server stopped");
    }

    private void setupRoutes(){
        server.path("/rooms",()->{
            server.get("/:name",(request, response) -> {
                logger().info("I've received a request to path /room"+request.params(":name"));
                response.status(200);

                String body = "You have requested room"+request.params(":name");
                response.body(body);

                return body;
            });
        });
    }
}
