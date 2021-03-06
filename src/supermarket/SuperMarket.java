package supermarket;

import eventsim.Event;
import eventsim.EventSim;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author evenal
 */
public class SuperMarket {

    public static final int NUM_CHECKOUTS = 3;
    public static final int NUM_CUSTOMERS = 50;
    Checkout[] checkouts;
    List<Customer> customers;
    List<Event> eventList;


    public SuperMarket() {
        checkouts = new Checkout[NUM_CHECKOUTS];
        for (int i = 0; i < NUM_CHECKOUTS; i++) {
            checkouts[i] = new Checkout(this, i);
        }
        customers = new ArrayList<>();
        eventList = new ArrayList<>();


        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            Customer customer = new Customer(this, i);
            eventList.add(new BeginShoppingEvent(customer));
            customers.add(customer);
        }
    }

    public Checkout addCustomerToShortestQueue(){
        Checkout shortestQueue = checkouts[0];
        for(Checkout checkout : checkouts){
            if(checkout.getLastCustomerLeaveTime() < shortestQueue.getLastCustomerLeaveTime()){
                shortestQueue = checkout;
                }
        }
        return shortestQueue;
    }


    public void startSim() {
        EventSim sim = EventSim.getInstance();
        sim.setup(eventList);
        sim.run();
    }
}
