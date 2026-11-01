
public class cinemashow {

    private String movieTitle;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    public cinemashow(String movieTitle, int capacity) {
        this.movieTitle = movieTitle;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    public cinemashow(String movieTitle) {
        this(movieTitle, 100);
    }

    public boolean book(int seats) {
        if (seats > 0 && seats <= seatsAvailable) {
            seatsAvailable -= seats;
            totalBooked += seats;
            return true;
        }
        return false;
    }

    // Cancel seats
    public void cancel(int seats) {
        if (seats > 0) {
            seatsAvailable += seats;

            if (seatsAvailable > capacity) {
                seatsAvailable = capacity;
            }
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        cinemashow show1 = new cinemashow("Interstellar", 5);
        cinemashow show2 = new cinemashow("Dune");

        System.out.println("A book 3 -> " + show1.book(3)
                + " | seats " + show1.getSeatsAvailable());

        System.out.println("A book 4 -> " + show1.book(4)
                + " | seats " + show1.getSeatsAvailable());

        show1.cancel(1);

        System.out.println("A cancel 1 | seats "
                + show1.getSeatsAvailable());

        System.out.println("B book 10 -> " + show2.book(10)
                + " | seats " + show2.getSeatsAvailable());

        System.out.println("Total booked across shows: "
                + cinemashow.getTotalBooked());
    }
}
