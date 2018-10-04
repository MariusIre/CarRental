package ro.jademy.carrental.cars.specs;

import java.util.Date;

public enum State {
    RENTED("Rented"),
    AVAILABLE("Available"),
    SERVICE("Service");

    private String name;
    private Date startDate;
    private Date endDate;

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setDates(Date startDate,Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
