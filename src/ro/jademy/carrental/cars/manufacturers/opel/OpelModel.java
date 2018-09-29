package ro.jademy.carrental.cars.manufacturers.opel;

public enum OpelModel {
    ASTRA("Astra"),
    INSIGNIA("Insignia"),
    CORSA("Corsa");

    private String name;

    OpelModel(String model) {
        this.name = model;
    }

    public String getName() {
        return name;
    }
}
