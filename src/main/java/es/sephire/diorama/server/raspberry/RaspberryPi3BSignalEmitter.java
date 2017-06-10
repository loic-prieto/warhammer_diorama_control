package es.sephire.diorama.server.raspberry;

import es.sephire.diorama.server.DeviceAdapter;
import es.sephire.diorama.server.Loggable;
import es.sephire.diorama.server.SignalEmitter;
import es.sephire.diorama.server.model.Scenario;
import io.vavr.control.Option;

/**
 * RaspberryPI 3 model B implementation of a signal emitter.
 *
 * For our first approach, the emitter will transmit for every device a signal.
 * Each device type will have a corresponding adapter for the raspberry that will
 * emit the signal.
 *
 * The general behaviour of the raspberry pi 3 B will be to emit the signals one
 * after the other, and hope that no noticeable flickering is happening for the lights.
 * If there is, another approach will have to be made, or some more complex circuits built.
 *
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public class RaspberryPi3BSignalEmitter implements SignalEmitter, Loggable {

    private DeviceAdapterFactory adapterFactory;

    public RaspberryPi3BSignalEmitter() {
        this.adapterFactory = new DeviceAdapterFactory();
    }
    public RaspberryPi3BSignalEmitter(DeviceAdapterFactory adapterFactory) {
        this.adapterFactory = adapterFactory;
    }

    @Override
    public void emit(Scenario scenario) {
        scenario.getDevices().forEach((device)->{

            Option<? extends DeviceAdapter> adapter = adapterFactory.getAdapter(device);
            if(adapter.isDefined()){
                adapter.get().emit();
            } else {
                logger().error("Could not find an adapter for device %d",device.getIdentifier());
            }
        });

    }
}
