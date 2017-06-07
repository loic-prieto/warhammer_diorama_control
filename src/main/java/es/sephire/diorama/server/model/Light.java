package es.sephire.diorama.server.model;

import io.vavr.Tuple3;

/**
 * A light is an electronic device that can be configured
 * with a color combination.
 * The color combination also carries its intensity.
 *
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public class Light {
    private int identifier;
    private LightState state;
    private Tuple3<Byte,Byte,Byte> color;


}
