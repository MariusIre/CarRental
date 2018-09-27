package ro.jademy.carrental.cars.components.gearbox;

public enum GearBoxType {
    MANUAL("Manual"),
    AUTOMATIC("Automatic"),
    SWITCHABLE("Swichable");

    private String transmission;

    GearBoxType(String transmission) {
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }
}
