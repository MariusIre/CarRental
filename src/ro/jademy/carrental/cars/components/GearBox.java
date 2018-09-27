package ro.jademy.carrental.cars.components;

import ro.jademy.carrental.cars.components.gearbox.GearBoxType;

public class GearBox {
    private GearBoxType type;

    public GearBox(GearBoxType type) {
        this.type = type;
    }

    public GearBoxType getType() {
        return type;
    }
}
