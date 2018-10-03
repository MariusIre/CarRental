package ro.jademy.carrental.cars.manufacturers.opel;

import ro.jademy.carrental.cars.components.BodyKit;
import ro.jademy.carrental.cars.components.Engine;
import ro.jademy.carrental.cars.components.GearBox;

public abstract class OpelAstra extends Opel {

    public OpelAstra(BodyKit bodyKit, Engine engine, GearBox gearBox, Integer year, int basePrice) {
        super(OpelModel.ASTRA, bodyKit, engine, gearBox, year, basePrice);
    }
}
