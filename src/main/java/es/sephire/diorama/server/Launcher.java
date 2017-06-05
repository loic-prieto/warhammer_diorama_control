package es.sephire.diorama.server;

import es.sephire.diorama.server.config.ConfigurationProvider;
import es.sephire.diorama.server.config.EnvironmentalConfiguration;
import es.sephire.diorama.server.web.WebServer;

/**
 * The launcher for the server.
 * Takes care of initializing both the raspberry pi server and
 * the web server (that is the web control panel).
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public class Launcher implements Loggable {

    private WebServer webServer;

    Launcher(ConfigurationProvider configuration) {
        this.webServer = new WebServer(configuration);
    }

    public void start(){
        this.webServer.start();
    }

    public static void main(String[] args) {
        ConfigurationProvider configuration = new EnvironmentalConfiguration("WH_DIORAMA");

        Launcher launcher = new Launcher(configuration);
        launcher.start();
    }
}
