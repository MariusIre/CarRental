package ro.jademy.carrental.cars.components;

import ro.jademy.carrental.cars.components.body.BodyKitType;
import ro.jademy.carrental.cars.components.body.ColorType;
import ro.jademy.carrental.cars.components.body.DoorNumberType;

public class BodyKit {

    private String chassisNo;
    private BodyKitType type;
    private ColorType colorType;
    private DoorNumberType doorNumberType;

    public BodyKit(String chassisNo, ColorType colorType, BodyKitType type, DoorNumberType doorNumberType) {
        this.chassisNo = chassisNo;
        this.colorType = colorType;
        this.type = type;
        this.doorNumberType = doorNumberType;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public BodyKitType getType() {
        return type;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public DoorNumberType getDoorNumberType() {
        return doorNumberType;
    }
}
