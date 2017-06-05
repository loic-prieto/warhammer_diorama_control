package es.sephire.diorama.server.config;

/**
 * Env vars implementation for the configuration interface.
 * Will retrieve configuration values from Environmental Variables.
 *
 * The class can optionally prefix all keys with a given prefix, of
 * empty default value.
 *
 * You can use the class as follows:
 * ConfigurationProvider config = new EnvironmentalConfiguration("SOME_PREFIX");
 * int port = config.getInt("server_port"); // Will seek SOME_PREFIX_SERVER_PORT from env vars
 *
 * Note that while conventions on environmental variables is to uppercase them
 * you can specify them as lowercased in your code, and this class will take
 * care of normalizing them before requesting them.
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public class EnvironmentalConfiguration implements ConfigurationProvider {

    private String prefix;

    public EnvironmentalConfiguration(String prefix) {
        this.prefix = prefix;
    }
    public EnvironmentalConfiguration(){
        this("");
    }

    @Override
    public String get(String key) {
        String value = System.getenv(this.normalizeKey(key));

        if(value == null){
            throw new ConfigurationNotFound(key);
        }
        return value;
    }

    private String normalizeKey(String key) {
        return this.prefix+"_"+key.toUpperCase();
    }
}
