package ro.jademy.carrental.cars.components.body;

public enum DoorNumberType {
    TWO(2),
    FOUR(4),
    SIX(6);

    private final Integer numberOfDoors;

    DoorNumberType(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors.intValue();
    }

    @Override
    public String toString() {
        return "numberOfDoors";
    }
}
