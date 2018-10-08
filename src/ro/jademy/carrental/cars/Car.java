package ro.jademy.carrental.cars;

import ro.jademy.carrental.cars.components.BodyKit;
import ro.jademy.carrental.cars.components.Engine;
import ro.jademy.carrental.cars.components.GearBox;
import ro.jademy.carrental.cars.specs.BasePrice;
import ro.jademy.carrental.cars.specs.CarSpec;
import ro.jademy.carrental.cars.specs.Make;
import ro.jademy.carrental.cars.specs.State;
import ro.jademy.carrental.persons.Customer;

import java.math.BigDecimal;
import java.util.*;

public abstract class Car {

    protected Make make;
    protected BodyKit bodyKit;
    protected Engine engine;
    protected GearBox gearBox;
    protected Integer year;
    protected BasePrice basePrice;
    protected State state;
    protected ArrayList<Customer> customers = new ArrayList<>();

    public Car(Make make, BodyKit bodyKit, Engine engine, GearBox gearBox, Integer year, int basePrice) {
        this.make = make;
        this.bodyKit = bodyKit;
        this.engine = engine;
        this.gearBox = gearBox;
        this.year = year;
        this.basePrice = new BasePrice(new BigDecimal(basePrice));
        this.state = State.AVAILABLE;
    }

    //--------------------------- SETTERS -----------------------------//

    public void setMake(Make make) {
        this.make = make;
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

    public void setBasePrice(BasePrice basePrice) {
        this.basePrice = basePrice;
    }

    public void setState(State state) {
        this.state = state;
    }

    //----------------------------- GETTERS ------------------------------//

    public String getMake() {
        return make.getName();
    }

    public String getChassisNo() {
        return bodyKit.getChassisNo();
    }

    public String getBody() {
        return bodyKit.getType().getName();
    }

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

    public int getBasePrice() {
        return basePrice.getBasePrice();
    }

    public State getState() {
        return state;
    }

    //---------------------------- FUNCTIONS -------------------------------//

    /**
     * Returns a string which is the value of a car attribute.
     * Returned value is based on parameter.
     * Parameter must be a value from Enum CarSpec
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

    /**
     * Add customer to car customers.
     * A car have a list of past customers.
     * If a car is currently rented the the last customer from customers array
     * is the customer in use.
     */
    public void addCustomerToCar(Customer customer) {
        customers.add(customer);
    }

    /**
     * Prints in a line most important specs of a car
     */
    public void showCar() {
        int maxStringSize = 14;
        ArrayList<String> args = new ArrayList<>();
        args.add(bodyKit.getChassisNo());
        args.add(make.getName());
        args.add(bodyKit.getType().getName());
        args.add(engine.getModel());
        args.add(engine.getFuelType().getName());
        args.add(bodyKit.getDoorNumberType().getNumberOfDoors() + "");
        args.add(gearBox.getType().getName());
        args.add(year.toString());
        args.add(state.getName());
        args.add(basePrice.getBasePrice()/100 + " " + basePrice.getCurrency());
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

    public void changeCarState(State state, Date startDate, int numberOfDays) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(startDate);
        cal.add(Calendar.DAY_OF_MONTH, numberOfDays);
        changeCarState(state, startDate, cal.getTime());
    }

    public void changeCarState(State state, Date startDate, Date endDate) {
        switch (state) {
            case RENTED:
                this.state = State.RENTED;
                this.state.setDates(startDate, endDate);
                break;
            case SERVICE:
                this.state = State.SERVICE;
                this.state.setDates(startDate, endDate);
                break;
            case AVAILABLE:
                this.state = State.AVAILABLE;
                this.state.setDates(null, null);
        }
    }

    /**Calculates number or working days and weekend days in a week
     * and adds a 25% increase to price on weekend days.
     *
     * @return a BigDecimal containing the amount of money.
     */
    public BigDecimal getPrice() {
        int numberOfDays = daysBetween(state.getStartDate(), state.getEndDate());
        System.out.println("Number of days " + numberOfDays);
        int numberOfWorkingDays = getWorkingDaysBetweenTwoDates(state.getStartDate(), state.getEndDate());
        System.out.println("Number of working days " + numberOfWorkingDays);
        int numberOfWeekendDays = numberOfDays - numberOfWorkingDays;
        System.out.println("Number of weekend days " + numberOfWeekendDays);
        BigDecimal price = new BigDecimal((basePrice.getBasePrice() * numberOfWorkingDays) +
                ((basePrice.getBasePrice() * numberOfWeekendDays) * 125 / 100));
        System.out.println("For the price of: " + price.intValue()/100 + " €");
        return price;
    }

    /**Calculates number of days between to dates.
     * @param d1 - starting date
     * @param d2 - end date
     * @return number of days between to dates
     */
    public int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        int workDays = 0;

        //Return 0 if start and end are the same
        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return 0;
        }

        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        do {
            //excluding start date
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                ++workDays;
            }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date

        return workDays;
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
