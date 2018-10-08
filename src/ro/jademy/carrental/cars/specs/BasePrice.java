package ro.jademy.carrental.cars.specs;

import java.math.BigDecimal;

public class BasePrice {

    private BigDecimal basePrice;
    private String currency;

    public BasePrice(BigDecimal basePrice){
        this.basePrice = basePrice;
        this.currency = "€";
    }

    public int getBasePrice() {
        return basePrice.intValue();
    }

    public String getCurrency() {
        return currency;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }
}
