package es.sephire.diorama.server.config;

/**
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public class ConfigurationNotFound extends RuntimeException {

    private String key;

    ConfigurationNotFound(String key){
        super("The key " + key + " could not be found.");
        this.key = key;
    }
}
