package ro.jademy.carrental.cars.specs;

public enum Make {
    DACIA("Dacia"),
    OPEL("Opel"),
    BMW("BMW"),
    AUDI("Audi"),
    MERCEDES("Mercedes");

    private String name;

    Make(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
