package ro.jademy.carrental.cars.manufacturers.dacia;

public enum DaciaModel {
    LOGAN("Logan"),
    DUSTER("Duster"),
    SANDERO("Sandero");

    private String name;

    DaciaModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
