package ro.jademy.carrental.cars;

import ro.jademy.carrental.cars.components.BodyKit;
import ro.jademy.carrental.cars.components.Engine;
import ro.jademy.carrental.cars.components.GearBox;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Car {

    private String make;
    private String model;
    private BodyKit bodyKit;
    private Engine engine;
    private GearBox gearBox;
    private Integer year;
    private BigDecimal basePrice;
    private Boolean isCarRented;

    public Car() {
        this.isCarRented = false;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBodyKit(BodyKit bodyKit) {
        this.bodyKit = bodyKit;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public void showCar() {
        int maxStringSize = 14;
        ArrayList<String> args = new ArrayList<>();
        args.add(bodyKit.getChassisNo());
        args.add(make);
        args.add(model);
        args.add(engine.getModel());
        args.add(engine.getFuelType().getFuelName());
        args.add(bodyKit.getType().getBodyKit());
        args.add(bodyKit.getDoorNumberType().getNumberOfDoors() + "");
        args.add(gearBox.getType().getTransmission());
        args.add(year.toString());
        args.add(isCarRented.toString());
        args.add(basePrice.toString());
        for (String str : args) {
            if (maxStringSize > str.length()) {
                String emptySpace = "";
                for (int i = 0; i < maxStringSize - str.length(); i++) {
                    emptySpace = emptySpace + " ";
                }
                System.out.printf("%s" + emptySpace, str);
                System.out.print("| ");
            } else {
                System.out.printf("%s", str);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(bodyKit.getChassisNo(), car.bodyKit.getChassisNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodyKit.getChassisNo());
    }
}
