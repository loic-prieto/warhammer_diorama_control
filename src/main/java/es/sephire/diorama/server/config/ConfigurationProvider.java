package es.sephire.diorama.server.config;

/**
 * Class to implement by configuration providers. Defines the basic operations
 * to retrieve configurations values from a given key.
 *
 * The interface provides for some convenience default methods that perform
 * basic type casting.
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public interface ConfigurationProvider {

    /**
     * Retrieves a configuration parameter value from a given key.
     * @param key
     * @return the value of the configuration parameter
     * @throws ConfigurationNotFound if the key is not found
     */
    String get(String key) throws ConfigurationNotFound;

    default int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    default double getDouble(String key) {
        return Double.parseDouble(get(key));
    }

    default float getFloat(String key) {
        return Float.parseFloat(get(key));
    }
}
