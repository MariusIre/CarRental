package ro.jademy.carrental.cars.manufacturers.dacia;

import ro.jademy.carrental.cars.Car;
import ro.jademy.carrental.cars.components.BodyKit;
import ro.jademy.carrental.cars.components.Engine;
import ro.jademy.carrental.cars.components.GearBox;

import static ro.jademy.carrental.cars.specs.Make.DACIA;

public abstract class Dacia extends Car {

    protected DaciaModel daciaModel;

    public Dacia(DaciaModel daciaModel, BodyKit bodyKit, Engine engine, GearBox gearBox, Integer year, int basePrice) {
        super(DACIA, bodyKit, engine, gearBox, year, basePrice);
        this.daciaModel = daciaModel;
    }
}
