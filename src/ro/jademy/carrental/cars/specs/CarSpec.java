package ro.jademy.carrental.cars.specs;

public enum CarSpec {
    MAKE("Make"),
    BODY("Body"),
    BUDGET("Budget"),
    YEAR("Year"),
    FUEL("Fuel"),
    TRANSMISSION("Transmission"),
    STATE("State");

    private String name;

    CarSpec(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
