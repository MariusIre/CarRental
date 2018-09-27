package ro.jademy.carrental.cars.components.body;

public enum BodyKitType {
    SEDAN("Sedan"),
    COUPE("Coupe"),
    HATCHBACK("Hatchback"),
    CONVERTIBLE("Convertible"),
    WAGON("Convertible"),
    SUV("SUV");

    private String bodyKit;

    BodyKitType(String bodyKit) {
        this.bodyKit = bodyKit;
    }

    public String getBodyKit() {
        return bodyKit;
    }
}
