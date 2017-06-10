package es.sephire.diorama.server.model;

import io.vavr.collection.Set;
import lombok.Data;

/**
 * A scenario contains manipulable electronic devices.
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
@Data
public class Scenario {
    private Set<Device> devices;
}
