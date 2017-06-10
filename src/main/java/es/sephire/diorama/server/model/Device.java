package es.sephire.diorama.server.model;

import lombok.Data;

/**
 * The base class for devices on a scenario.
 *
 * All devices have an identifier which can be used to
 * send them the commands to manipulate them.
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
@Data
public abstract class Device {
    private int identifier;
}
