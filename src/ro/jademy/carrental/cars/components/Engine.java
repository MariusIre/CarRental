package ro.jademy.carrental.cars.components;

import ro.jademy.carrental.cars.components.engine.FuelType;

public class Engine {

    private String model;
    private String horsePower;
    private FuelType fuelType;

    public Engine(String model, String horsePower, FuelType fuelType) {
        this.model = model;
        this.horsePower = horsePower;
        this.fuelType = fuelType;
    }

    public String getModel() {
        return model;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}
