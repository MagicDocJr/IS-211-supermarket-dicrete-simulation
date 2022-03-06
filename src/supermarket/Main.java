package supermarket;

public class Main {
    public static void main(String[] args) {
        SuperMarket superMarket = new SuperMarket();
        superMarket.startSim();
        System.out.println("\nStatistics: ");
        for(Checkout checkout : superMarket.checkouts){
            System.out.println(checkout + ": ");
            System.out.println("Customers spent on average " + checkout.customerAverageQueueTime() + " time units waiting in queue\n");

        }
    }

}
