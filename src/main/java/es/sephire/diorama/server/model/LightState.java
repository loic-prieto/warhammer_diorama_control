package es.sephire.diorama.server.model;

/**
 * The possible states of a light device.
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public enum LightState {
    ON, // Healthy light on
    OFF, // Turned off
    TITILLATING, // mildly unwell light that titillates
    BROKEN; // Erratic behaviour

}
