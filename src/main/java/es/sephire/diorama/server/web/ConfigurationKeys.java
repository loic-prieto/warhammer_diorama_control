package es.sephire.diorama.server.web;

/**
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public enum ConfigurationKeys {
    port("web_server_port");

    private String key;
    ConfigurationKeys(String key) {
        this.key = key;
    }

    public String getKey(){return this.key;}

    @Override
    public String toString() {
        return key;
    }
}
