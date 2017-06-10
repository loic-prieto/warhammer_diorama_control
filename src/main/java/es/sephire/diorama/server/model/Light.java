package es.sephire.diorama.server.model;

import io.vavr.Tuple3;
import lombok.Data;

/**
 * A light is an electronic device that can be configured
 * with a color combination.
 * The color combination also carries its intensity.
 *
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
@Data
public class Light extends Device {
    private int identifier;
    private LightState state;
    private Tuple3<Byte,Byte,Byte> color;


}
