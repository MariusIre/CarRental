package ro.jademy.carrental.cars.manufacturers.dacia;

import ro.jademy.carrental.cars.Car;
import static ro.jademy.carrental.cars.specs.Make.DACIA;

public abstract class Dacia extends Car {

    public Dacia(DaciaModel daciaModel) {
        setModel(daciaModel.getName());
        setMake(DACIA);
    }
}
