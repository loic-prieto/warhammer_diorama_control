package es.sephire.diorama.server;

import es.sephire.diorama.server.model.Scenario;

/**
 * A signal emitter takes care of sending the required
 * digital/analog signals of the different devices a
 * scenario is composed of to a digital circuit.
 *
 * Each emitter knows how to format and distribute the signals
 * on the controller used. For example, a RaspberryPi 3
 * signal emitter knows what signals to send on what pins
 * for a given scenario.
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public interface SignalEmitter {
    void emit(Scenario scenario);
}
