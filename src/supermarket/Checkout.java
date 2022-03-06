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
        return totalQueueWaitTime / SuperMarket.NUM_CUSTOMERS;
    }
    public double checkoutAverageQueueSize(){
        return totalQueueSize / lastCustomerLeaveTime;
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

    public void addToQueue(Customer customer){
        customerQueue.add(customer);
    }

}
