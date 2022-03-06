package supermarket;

import java.util.Deque;
import java.util.LinkedList;


/**
 *
 * @author evenal
 */
public class Checkout {
    public static final int PROD_DURATION = 2;
    public static final int PAY_DURATION = 10;
    public Deque<Customer> customerQueue;
    int lastCustomerLeaveTime;
    double totalQueueWaitTime;
    double totalQueueSize;
    int maxQueueSize;
    int maxQueueWaitDuration;
    SuperMarket shop;
    String name;



    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout_" + i;
        this.customerQueue = new LinkedList<>();

    }

    public int checkoutDuration(int numProducts){
        return (PROD_DURATION * numProducts) + PAY_DURATION;
    }

    public int getQueueWaitTime(Customer customer){
        Customer lastCustomerInQueue = customerQueue.peekLast();
        if (lastCustomerInQueue == null){
            return 0;
        } else {
            return lastCustomerInQueue.leaveTime - customer.endShoppingTime;
        }
    }

    public double customerAverageQueueTime(){
        return totalQueueWaitTime / totalQueueSize;
    }

    public int getLongestQueueSize(){
        return maxQueueSize;
    }

    public void setLongestQueueSize() {
        if (this.maxQueueSize < customerQueue.size()) {
            this.maxQueueSize = customerQueue.size();
        }
    }

    public void setMaxQueueWaitDuration(int waitDuration){
        if (this.maxQueueWaitDuration < waitDuration){
            this.maxQueueWaitDuration = waitDuration;
        }
    }

    public int getMaxQueueWaitDuration(){
        return maxQueueWaitDuration;
    }

    public int getLastCustomerLeaveTime() {
        if (customerQueue.peekLast() == null) {
            return 0;
        } else {
            return customerQueue.peekLast().leaveTime;
        }
    }

    public String toString(){
        return name;
    }



}
