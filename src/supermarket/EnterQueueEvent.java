package supermarket;

import eventsim.Event;

public class EnterQueueEvent extends Event {
    Customer customer;
    Checkout checkout;


    public EnterQueueEvent(Customer customer){
        super(customer.endShoppingTime + 1);
        this.customer = customer;
        this.customer.joinShortestCheckout();
        this.checkout = customer.checkout;
        customer.checkoutDuration = checkout.checkoutDuration(customer.numProducts);
        customer.checkoutTime = checkout.getQueueWaitTime(customer) + 1 +  customer.endShoppingTime;
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        customer.queueWaitDuration = checkout.getQueueWaitTime(customer);
        checkout.totalQueueSize++;
        checkout.totalQueueWaitTime += customer.queueWaitDuration;
        checkout.setMaxQueueWaitDuration(customer.queueWaitDuration);
        checkout.customerQueue.add(customer);
        checkout.setLongestQueueSize();

    }

    @Override
    public Event happen() {

        return new BeginCheckoutEvent(customer, checkout);
    }

    @Override
    public String toString() {
        return customer + " Enters queue at " + checkout;
    }
}
