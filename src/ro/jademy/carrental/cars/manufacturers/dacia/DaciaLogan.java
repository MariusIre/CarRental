package ro.jademy.carrental.cars.manufacturers.dacia;

import ro.jademy.carrental.cars.components.BodyKit;
import ro.jademy.carrental.cars.components.Engine;
import ro.jademy.carrental.cars.components.GearBox;

public abstract class DaciaLogan extends Dacia {

    public DaciaLogan(BodyKit bodyKit, Engine engine, GearBox gearBox, Integer year, int basePrice) {
        super(DaciaModel.LOGAN, bodyKit, engine, gearBox, year, basePrice);
    }
}
