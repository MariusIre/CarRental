package ro.jademy.carrental.cars.manufacturers.opel;

import ro.jademy.carrental.cars.Car;

import static ro.jademy.carrental.cars.specs.Make.OPEL;

public abstract class Opel extends Car {

    public Opel(OpelModel opelModel){
        setModel(opelModel.getName());
        setMake(OPEL);
    }
}
