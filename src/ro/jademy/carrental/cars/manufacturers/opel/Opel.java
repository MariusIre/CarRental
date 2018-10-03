package ro.jademy.carrental.cars.manufacturers.opel;

import ro.jademy.carrental.cars.Car;
import ro.jademy.carrental.cars.components.BodyKit;
import ro.jademy.carrental.cars.components.Engine;
import ro.jademy.carrental.cars.components.GearBox;

import static ro.jademy.carrental.cars.specs.Make.OPEL;

public abstract class Opel extends Car {

    protected OpelModel opelModel;

    public Opel(OpelModel opelModel, BodyKit bodyKit, Engine engine, GearBox gearBox, Integer year, int basePrice) {
        super(OPEL, bodyKit, engine, gearBox, year, basePrice);
        this.opelModel = opelModel;
    }
}
