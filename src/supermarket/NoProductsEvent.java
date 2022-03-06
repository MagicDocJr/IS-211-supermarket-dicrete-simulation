package supermarket;

import eventsim.Event;

public class NoProductsEvent extends Event {
    Customer customer;
    Checkout checkout;

    public NoProductsEvent(Customer customer) {
        super(customer.leaveTime);
        this.customer = customer;
        checkout = customer.checkout;
    }

    @Override
    public Event happen() {
        return null;
    }

    @Override
    public String toString() {
        return customer + " leaves the store without any products";
    }
}

