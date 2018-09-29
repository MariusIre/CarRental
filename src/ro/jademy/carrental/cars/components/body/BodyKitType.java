package ro.jademy.carrental.cars.components.body;

public enum BodyKitType {
    SEDAN("Sedan"),
    COUPE("Coupe"),
    HATCHBACK("Hatchback"),
    CONVERTIBLE("Convertible"),
    WAGON("Convertible"),
    SUV("SUV");

    private String body;

    BodyKitType(String body) {
        this.body = body;
    }

    public String getName() {
        return body;
    }
}
