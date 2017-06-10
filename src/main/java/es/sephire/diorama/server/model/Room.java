package es.sephire.diorama.server.model;

import io.vavr.Tuple3;
import io.vavr.collection.List;
import lombok.Data;

/**
 * A room is a set of addressable rgb leds controlled under
 * the same name/identifier.
 * On a raspberry pi, it may be a set of leds controlled
 * by the same GPIO pin, or an intermediary controller that
 * will multiplex the signals based on room identifier.
 *
 * A room can display several changing behaviours over time
 * regarding it's lighting:
 * - change the color of the leds to a fixed value.
 * - change the intensity of the light to a fixed value.
 * - pulsating intensity of the light.
 *
 * A room acts as proxy of the contained lights, unless
 * a particular light has its own behaviour.
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
@Data
public class Room extends Device {
    /**
     * On which lights this rooms operates.
     */
    private List<Light> lights;
    /**
     * The state of the room applies it's config to
     * all it's lights, if a light has no specific
     * state of it's own.
     */
    private LightState roomState;
    /**
     * The name of the room, the human identifier.
     */
    private String name;
    /**
     * The color of the room applies to all of it's
     * contained lights, if those lights have no specific
     * light of their own.
     */
    private Tuple3<Byte,Byte,Byte> color;

}
