package supermarket;

import eventsim.EventSim;


/**
 *
 * @author evenal
 */
public class Customer {
    // customer will pick a random number of products between these two values
    public static final int MAX_PRODUCTS = 100;
    public static final int MIN_PRODUCTS = 0;

    // customer will spend random amount of time between these values before
    // going to check out
    public static final int MAX_SHOP_TIME = 50;
    public static final int MIN_SHOP_TIME = 1;

    SuperMarket shop;
    String name;
    Checkout checkout;

    int beginShoppingTime;
    int shoppingDuration;
    int numProducts;
    int endShoppingTime;
    int queueWaitDuration;
    int checkoutTime;
    int checkoutDuration;
    int leaveTime;


    public Customer(SuperMarket shop, int time) {
        this.shop = shop;
        name = this.getClass().getSimpleName() + "_" + time;
        beginShoppingTime = EventSim.nextInt(0,50);
        numProducts = EventSim.nextInt(MIN_PRODUCTS, MAX_PRODUCTS);
        shoppingDuration = EventSim.nextInt(MIN_SHOP_TIME, MAX_SHOP_TIME);
        endShoppingTime = beginShoppingTime + shoppingDuration;


    }

    @Override
    public String toString() {
        return name;
    }

    public void joinShortestCheckout(){
        this.checkout = shop.addCustomerToShortestQueue();
    }

