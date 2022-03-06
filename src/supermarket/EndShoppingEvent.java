package supermarket;

import eventsim.Event;
import eventsim.EventSim;


/**
 * A customer finishes shopping and heads for the checkout with the shortest
 * queue
 *
 * @author evenal
 */
public class EndShoppingEvent extends Event {
    Customer customer;



    public EndShoppingEvent(Customer customer) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        if (customer.numProducts > 0) {

            return new EnterQueueEvent(customer);
        } else {
            customer.leaveTime = customer.leaveTime + 1;
            return new NoProductsEvent(customer);
        }
    }


    public String toString() {
        return customer + " is done shopping";
    }

}
