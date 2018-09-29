package ro.jademy.carrental.cars.specs;

public enum State {
    RENTED("Rented"),
    AVAILABLE("Available"),
    SERVICE("Service");

    private String name;

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
