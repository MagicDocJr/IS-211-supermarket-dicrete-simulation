package eventsim;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;


/**
 * The core class of the discrete event simulation
 *
 * @author evenal
 */
public class EventSim {

    private static final EventSim theSim = new EventSim();
    PriorityQueue<Event> eventQueue;
    int clock;
    Random random;

    public EventSim() {
        eventQueue = new PriorityQueue<>(new EventTimeComparator());
        random = new Random(42);
    }

    public static EventSim getInstance() {
        return theSim;
    }

    public static int getClock() {
        return theSim.clock;
    }

    /**
     * @param min for the random number
     * @param max for the random number
     * @return random number in the interval min-max
     * TODO: Consider removing this wrapping.
     */
    public static int nextInt(int min, int max) {
        return min + theSim.random.nextInt(max - min);
    }


    /**
     * Prepare the simulation
     * @param initialEvents a list of "start" events
     */
    public void setup(List<Event> initialEvents) {
        for (Event event : initialEvents)
            eventQueue.add(event);
    }


    public void addEvent(Event event) {
        if (event == null)
            return;
        eventQueue.add(event);
    }


    /**
     * Run the simulation. Advances the time (clock) to the time when the next
     * event happens, executes the next event, and repeats until the event queue
     * is empty. You can also rewrite this to stop at a predetermined time (e.g.
     * closing time)
     */
    public void run() {
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            clock = event.getTimeOfEvent();
            addEvent(event.happen());

            System.out.format("\n Time %d: Processing %s. \n\n Event queue:\n", clock, event);
            for (Event queuedEvent : eventQueue)
                System.out.println("     " + queuedEvent);
        }
    }
}
