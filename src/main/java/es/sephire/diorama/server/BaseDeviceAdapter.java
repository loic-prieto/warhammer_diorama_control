package es.sephire.diorama.server;

import es.sephire.diorama.server.model.Device;

/**
 * Base class for a device adapter, implements the basic
 * device wrapping.
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public abstract class BaseDeviceAdapter<T extends Device> implements DeviceAdapter {
    private Device device;

    @Override
    public void setDevice(Device device) {
        this.device = device;
    }

    protected T getDevice(){
        return (T)this.device;
    }
}
