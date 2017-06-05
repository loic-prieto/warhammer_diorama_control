package es.sephire.diorama.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mixin to provide logging capacities
 * to classes that implement it.
 *
 */
public interface Loggable {

    /**
     *
     * @return a fully initialized logger for the class
     */
    default Logger logger(){
        return LoggerFactory.getLogger(this.getClass());
    }
}
