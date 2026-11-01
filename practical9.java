
]public class SeatBookingRace {

    static class Booking {

        int seatsLeft = 5;

        // Without synchronization
        void bookUnsafe(String name) {
            if (seatsLeft > 0) {
                System.out.println(name + " is trying to book...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                seatsLeft--;
                System.out.println(name + " booking successful!");
            } else {
                System.out.println(name + " booking failed!");
            }
        }

        // With synchronization
        synchronized void bookSafe(String name) {
            if (seatsLeft > 0) {
                System.out.println(name + " is trying to book...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                seatsLeft--;
                System.out.println(name + " booking successful!");
            } else {
                System.out.println(name + " booking failed!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // -------- UNSAFE --------
        System.out.println("===== WITHOUT SYNCHRONIZATION =====");

        Booking b1 = new Booking();
        Thread[] threads1 = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int n = i + 1;

            threads1[i] = new Thread(()
                    -> b1.bookUnsafe("Thread-" + n)
            );

            threads1[i].start();
        }

        for (Thread t : threads1) {
            t.join();
        }

        System.out.println("Seats left: " + b1.seatsLeft);

        // -------- SAFE --------
        System.out.println("\n===== WITH SYNCHRONIZATION =====");

        Booking b2 = new Booking();
        Thread[] threads2 = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int n = i + 1;

            threads2[i] = new Thread(()
                    -> b2.bookSafe("Thread-" + n)
            );

            threads2[i].start();
        }

        for (Thread t : threads2) {
            t.join();
        }

        System.out.println("Seats left: " + b2.seatsLeft);
    }
}
