package supermarket;

import eventsim.Event;


/**
 * A customer enters the shop
 *
 * @author evenal
 */
public class BeginShoppingEvent extends Event {
    Customer customer;


    public BeginShoppingEvent(Customer customer) {
        super(customer.beginShoppingTime);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }

    @Override
    public String toString() {
        return  customer + " enters the store";
    }
}
