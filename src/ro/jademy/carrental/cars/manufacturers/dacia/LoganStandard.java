package ro.jademy.carrental.cars.manufacturers.dacia;

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


    public LoganStandard(BodyKit bodyKit, Engine engine, GearBox gearBox, Integer year, int basePrice) {
        super(bodyKit, engine, gearBox, year, basePrice);
    }

    public LoganStandard(String chassisNo, ColorType colorType, GearBoxType gearBoxType, Integer year, int basePrice) {
        super(new BodyKit(chassisNo, colorType, BodyKitType.SEDAN, DoorNumberType.FOUR),
                new Engine("1.2MPI", "75HP", FuelType.GASOLINE),
                new GearBox(gearBoxType),
                year,
                basePrice);
    }
}
