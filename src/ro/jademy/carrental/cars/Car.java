package ro.jademy.carrental.cars;

import ro.jademy.carrental.cars.components.BodyKit;
import ro.jademy.carrental.cars.components.Engine;
import ro.jademy.carrental.cars.components.GearBox;
import ro.jademy.carrental.cars.specs.CarSpec;
import ro.jademy.carrental.cars.specs.Make;
import ro.jademy.carrental.cars.specs.Model;
import ro.jademy.carrental.cars.specs.State;
import ro.jademy.carrental.persons.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Car {

    private Make make;
    private Model model;
    private BodyKit bodyKit;
    private Engine engine;
    private GearBox gearBox;
    private Integer year;
    private BigDecimal basePrice;
    private State state;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Car() {
        this.state = State.AVAILABLE;
    }

    //--------------------------- SETTERS -----------------------------//

    public void setMake(Make make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = new Model(model);
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

    public void setState(State state) {
        this.state = state;
    }

    //----------------------------- GETTERS ------------------------------//

    public String getMake() {
        return make.getName();
    }

    public String getModel() {
        return model.getName();
    }

    public String getChassisNo() {
        return bodyKit.getChassisNo();
    }

    public String getBody() {
        return bodyKit.getType().getName();}

    public String getColor() {
        return bodyKit.getColorType().getName();
    }

    public Engine getEngine() {
        return engine;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public Integer getYear() {
        return year;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public State getState() {
        return state;
    }

    //---------------------------- FUNCTIONS -------------------------------//

    /** Returns a string which is the value of a car attribute.
     *  Returned value is based on parameter.
     *  Parameter must be a value from Enum CarSpec
     */
    public String getFilter(CarSpec carSpec) {

        switch (carSpec.getName()) {
            case "Make":
                return this.make.getName();
            case "Body":
                return this.bodyKit.getType().getName();
            case "Budget":
                return this.basePrice.toString();
            case "Year":
                return this.year.toString();
            case "Fuel":
                return this.engine.getFuelType().getName();
            case "Transmission":
                return this.gearBox.getType().getName();
            case "State":
                return this.state.getName();
            default:
                return "";
        }
    }

    /** Add customer to car customers.
     *  A car have a list of past customers.
     *  If a car is currently rented the the last customer from customers array
     *  is the customer in use.
     */
    public void addCustomerToCar(Customer customer) {
        customers.add(customer);
    }

    public void showCar() {
        int maxStringSize = 14;
        ArrayList<String> args = new ArrayList<>();
        args.add(bodyKit.getChassisNo());
        args.add(make.getName());
        args.add(model.getName());
        args.add(engine.getModel());
        args.add(engine.getFuelType().getName());
        args.add(bodyKit.getType().getName());
        args.add(bodyKit.getDoorNumberType().getNumberOfDoors() + "");
        args.add(gearBox.getType().getName());
        args.add(year.toString());
        args.add(state.getName());
        args.add(basePrice.toString());
        for (String str : args) {
            if (maxStringSize > str.length()) {
                String emptySpace = "";
                for (int i = 0; i < maxStringSize - str.length(); i++) {
                    emptySpace = emptySpace + " ";
                }
                System.out.printf("%s" + emptySpace, str);
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
