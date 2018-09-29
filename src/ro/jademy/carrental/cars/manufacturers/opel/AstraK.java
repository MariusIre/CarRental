package ro.jademy.carrental.cars.manufacturers.opel;

import ro.jademy.carrental.cars.components.BodyKit;
import ro.jademy.carrental.cars.components.Engine;
import ro.jademy.carrental.cars.components.GearBox;
import ro.jademy.carrental.cars.components.body.BodyKitType;
import ro.jademy.carrental.cars.components.body.ColorType;
import ro.jademy.carrental.cars.components.body.DoorNumberType;
import ro.jademy.carrental.cars.components.engine.FuelType;
import ro.jademy.carrental.cars.components.gearbox.GearBoxType;

import java.math.BigDecimal;

public class AstraK extends OpelAstra {

    public AstraK(String chassisNo, ColorType colorType, GearBoxType gearBoxType, Integer year, BigDecimal basePrice) {
        setBodyKit(new BodyKit(chassisNo, colorType, BodyKitType.HATCHBACK, DoorNumberType.FOUR));
        setEngine(new Engine("1.5DCI", "105HP", FuelType.DIESEL));
        setGearBox(new GearBox(gearBoxType));
        setYear(year);
        setBasePrice(basePrice);
    }
}
