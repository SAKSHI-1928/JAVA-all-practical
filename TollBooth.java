
import java.util.Scanner;

public class TollBooth {

    // Record
    record Vehicle(String number, String type) {

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        while (true) {

            System.out.print("Enter Vehicle Number (or done to stop): ");
            String number = sc.next();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter Vehicle Type (bike/car/truck): ");
            String type = sc.next().toLowerCase();

            // Create Vehicle record
            Vehicle vehicle = new Vehicle(number, type);

            // Switch expression
            int toll = switch (vehicle.type()) {
                case "bike" ->
                    20;
                case "car" ->
                    50;
                case "truck" ->
                    150;
                default ->
                    0;
            };

            totalToll += toll;

            // Count vehicle types
            switch (vehicle.type()) {
                case "bike":
                    bikeCount++;
                    break;
                case "car":
                    carCount++;
                    break;
                case "truck":
                    truckCount++;
                    break;
            }
        }

        // Find most frequent vehicle type
        String mostFrequent;

        if (bikeCount >= carCount && bikeCount >= truckCount) {
            mostFrequent = "bike";
        } else if (carCount >= bikeCount && carCount >= truckCount) {
            mostFrequent = "car";
        } else {
            mostFrequent = "truck";
        }

        System.out.println("\nTotal Toll: " + totalToll);
        System.out.println("Most Frequent: " + mostFrequent);

        sc.close();
    }
}
