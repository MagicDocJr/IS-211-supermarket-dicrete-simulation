package supermarket;

import eventsim.Event;
import eventsim.EventSim;

public class BeginCheckoutEvent extends Event {
    Customer customer;
    Checkout checkout;


    public BeginCheckoutEvent(Customer customer, Checkout checkout){
        super(customer.checkoutTime + 1);
        this.customer = customer;
        this.checkout = customer.checkout;
    }
    @Override
    public Event happen() {
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration + 1;
        return new LeaveStoreEvent(customer);

    }

    @Override
    public String toString() {
        return customer + " is starting the checkout with " + customer.numProducts +  " number of products";
    }
}
