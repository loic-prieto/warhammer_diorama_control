package es.sephire.diorama.server.raspberry;

import es.sephire.diorama.server.BaseDeviceAdapter;
import es.sephire.diorama.server.DeviceAdapter;
import es.sephire.diorama.server.model.Device;
import es.sephire.diorama.server.model.Light;

/**
 * Transforms a Light model entity into a signal for the
 * raspberry pi 3.
 * It encodes the information in the following bits:
 * The first 5 pins are used to codify the identifier of the device
 * (this means there are at most, 32 devices).
 * Then 3 pins are used to transmit color and intensity for the rgb
 * spectrum. A digital bits-to-intensity is used to give value
 * to each pin.
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public class LightAdapter extends BaseDeviceAdapter<Light> {

    @Override
    public void emit() {

    }
}
