package ro.jademy.carrental.treasury;

import ro.jademy.carrental.persons.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Treasury {
    private ArrayList<Payment> payments = new ArrayList<>();

    public Treasury() {
    }

    public long getMoney() {
        return payments.stream().map(Payment::getAmount).count();
    }

    public void addPayment(Customer customer, BigDecimal amount) {
        payments.add(new Payment(customer, amount));
    }
}
