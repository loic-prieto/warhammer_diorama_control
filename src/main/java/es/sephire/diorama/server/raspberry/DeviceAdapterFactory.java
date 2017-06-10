package es.sephire.diorama.server.raspberry;

import es.sephire.diorama.server.DeviceAdapter;
import es.sephire.diorama.server.model.Device;
import es.sephire.diorama.server.model.Light;
import es.sephire.diorama.server.model.Room;
import io.vavr.Tuple2;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.collection.Set;
import io.vavr.control.Option;

/**
 * Allows to fetch an adapter class for the raspberry pi 3 b.
 * @author Loïc Prieto - loic.sephiroth@gmail.com
 */
public class DeviceAdapterFactory {
    private Map<Class<? extends Device>,Class<? extends DeviceAdapter>> adapterClasses;
    private Map<Class<? extends Device>,DeviceAdapter> adapterCache;

    public DeviceAdapterFactory() {
        this.adapterCache = HashMap.empty();
        this.adapterClasses = HashMap.of(
            Light.class, LightAdapter.class,
            Room.class,  RoomAdapter.class
        );
    }

    public Option<? extends DeviceAdapter> getAdapter(Device device) {
        Class<? extends Device> deviceClass = device.getClass();

        Option<? extends DeviceAdapter> adapter = adapterCache.get(deviceClass);
        if(adapter.isEmpty()) {
            adapter = adapterClasses
                .get(deviceClass)
                .flatMap((adapterClass)-> Option.of(DeviceAdapterFactory.instanceAdapter(adapterClass,device)));
            if(adapter.isDefined()){
                adapterCache.put(deviceClass,adapter.get());
            }
        }
        adapter.peek((a)-> a.setDevice(device));

        return adapter;
    }

    private static DeviceAdapter instanceAdapter(Class<? extends DeviceAdapter> adapterClass,Device device){
        DeviceAdapter da = null;

        try {
            da = adapterClass.newInstance();
            da.setDevice(device);
        } catch (InstantiationException|IllegalAccessException e) { }

        return da;
    }
}
