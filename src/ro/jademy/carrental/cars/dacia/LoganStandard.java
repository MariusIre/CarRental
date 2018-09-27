package ro.jademy.carrental.cars.dacia;

import ro.jademy.carrental.cars.components.BodyKit;
import ro.jademy.carrental.cars.components.Engine;
import ro.jademy.carrental.cars.components.GearBox;
import ro.jademy.carrental.cars.components.body.BodyKitType;
import ro.jademy.carrental.cars.components.body.ColorType;
import ro.jademy.carrental.cars.components.body.DoorNumberType;
import ro.jademy.carrental.cars.components.engine.FuelType;
import ro.jademy.carrental.cars.components.gearbox.GearBoxType;

import java.math.BigDecimal;

public class LoganStandard extends DaciaLogan {

    public LoganStandard(String chassisNo, ColorType colorType, GearBoxType gearBoxType, Integer year, BigDecimal basePrice) {
        setBodyKit(new BodyKit(chassisNo, colorType, BodyKitType.SEDAN, DoorNumberType.FOUR));
        setEngine(new Engine("1.2MPI", "75HP", FuelType.GASOLINE));
        setGearBox(new GearBox(gearBoxType));
        setYear(year);
        setBasePrice(basePrice);
    }
}
