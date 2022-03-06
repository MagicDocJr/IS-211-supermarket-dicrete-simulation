package supermarket;

import eventsim.Event;

public class LeaveStoreEvent extends Event {
    Customer customer;
    Checkout checkout;

    public LeaveStoreEvent(Customer customer) {
        super(customer.leaveTime);
        this.customer = customer;
        checkout = customer.checkout;
    }

    @Override
    public Event happen() {
        checkout.lastCustomerLeaveTime = customer.leaveTime;
        customer.checkout.customerQueue.remove(customer);
        return null;
    }

    @Override
    public String toString() {
        return customer + " leaves the store";
    }
}

