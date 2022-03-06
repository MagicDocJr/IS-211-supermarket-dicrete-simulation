package supermarket;

public class Main {
    public static void main(String[] args) {
        SuperMarket superMarket = new SuperMarket();
        superMarket.startSim();
        System.out.println("\nStatistics: ");
        for(Checkout checkout : superMarket.checkouts){
            System.out.println(checkout + ": ");
            System.out.println("Customers spent on average " + checkout.customerAverageQueueTime() + " time units waiting in queue.");
            System.out.println("The max length of the queue this day were " + checkout.getLongestQueueSize() );
            System.out.println("The longest queue wait duration for a single customer this day were " + checkout.getMaxQueueWaitDuration() + " time units\n");

        }
    }

}
