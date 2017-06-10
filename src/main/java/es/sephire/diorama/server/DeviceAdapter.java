package es.sephire.diorama.server;

import es.sephire.diorama.server.model.Device;

/**
 * Wraps a Device to provide interaction with the digital
 * controller.
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public interface DeviceAdapter {
    /**
     * Emit a signal from the underlying controller to
     * the circuit board.
     */
    void emit();

    /**
     * The instancing of device adapters is done dynamically, which
     * means the constructor can only be empty. We thus need a setter
     * for the device.
     *
     * @param device
     */
    void setDevice(Device device);
}
