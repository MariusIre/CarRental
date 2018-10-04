package ro.jademy.carrental.cars.manufacturers.opel;

import ro.jademy.carrental.cars.components.BodyKit;
import ro.jademy.carrental.cars.components.Engine;
import ro.jademy.carrental.cars.components.GearBox;
import ro.jademy.carrental.cars.components.body.BodyKitType;
import ro.jademy.carrental.cars.components.body.ColorType;
import ro.jademy.carrental.cars.components.body.DoorNumberType;
import ro.jademy.carrental.cars.components.engine.FuelType;
import ro.jademy.carrental.cars.components.gearbox.GearBoxType;

public class AstraH extends OpelAstra {

    public AstraH(String chassisNo, ColorType colorType, GearBoxType gearBoxType, Integer year, int basePrice) {
        super(new BodyKit(chassisNo, colorType, BodyKitType.COUPE, DoorNumberType.TWO),
                new Engine("1.8MPI", "175HP", FuelType.GASOLINE),
                new GearBox(gearBoxType),
                year,
                basePrice);
    }
}
