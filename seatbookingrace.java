
import java.util.ArrayList;
import java.util.List;

public class seatbookingrace {

    static final int seats = 10;
    static final int NUM_threads = 10;

    static class Unsafebooking {

        private int seatsLeft = seats;

    boolean book(){
            if (seatsLeft > 0) {
                try{thread.sleep(millis:millis:1);} catch (InterruptedException ignored) {
                }
                seatsLeft--;
                return true;
            }
                return false;
            }
        }
        
    }

    static class Safebooking {

        private int satsLeft = seats;

    

    public static void main(String[] args) throws InterruptedException {

        int expectedCount = NUM_THREADS * NUM_INCREMENTS;

        System.out.println("Expected total: " + expectedCount);
        System.out.println();

        UnsafeCounter unsafeCounter = new UnsafeCounter();
        runThreads(unsafeCounter::increment);
        System.out.println("Unsafe counter total: " + unsafeCounter.getCount());

        SafeCounter safeCounter = new SafeCounter();
        runThreads(safeCounter::increment);
        System.out.println("Safe counter total: " + safeCounter.getCount());
    }

    static void runThreads(Runnable incrementMethod)
            throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {

            Thread thread = new Thread(() -> {
                for (int j = 0; j < NUM_INCREMENTS; j++) {
                    incrementMethod.run();
                }
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
