package ro.jademy.carrental.treasury;

import ro.jademy.carrental.persons.Customer;

import java.math.BigDecimal;

public class Payment {
    private Customer customer;
    private BigDecimal amount;

    public Payment(Customer customer, BigDecimal amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
