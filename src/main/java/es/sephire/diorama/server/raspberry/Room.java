package es.sephire.diorama.server.raspberry;

import io.vavr.Tuple3;
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
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
@Data
public class Room {
    private int identifier;
    private String name;
    private Tuple3<Byte,Byte,Byte> color;
    private double intensity;


}
