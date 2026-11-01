
public class ParkingLot {

    private int twoWheelers;
    private int fourWheelers;

    private final int twoCap;
    private final int fourCap;

    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
        this.twoWheelers = 0;
        this.fourWheelers = 0;
    }

    public boolean park(String type) {

        if (type.equalsIgnoreCase("two")) {

            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                return true;
            } else {
                System.out.println("Two Wheeler Section Full");
                return false;
            }

        } else if (type.equalsIgnoreCase("four")) {

            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                return true;
            } else {
                System.out.println("Four Wheeler Section Full");
                return false;
            }
        }

        return false;
    }

    public void leave(String type) {

        if (type.equalsIgnoreCase("two")) {

            if (twoWheelers > 0) {
                twoWheelers--;
            }

        } else if (type.equalsIgnoreCase("four")) {

            if (fourWheelers > 0) {
                fourWheelers--;
            }
        }
    }

    public int getTwoWheelers() {
        return twoWheelers;
    }

    public int getFourWheelers() {
        return fourWheelers;
    }

    public static long getRevenue() {
        return revenue;
    }

    public static void main(String[] args) {

        ParkingLot p = new ParkingLot(2, 2);

        System.out.println("Park Two -> " + p.park("two"));
        System.out.println("Park Two -> " + p.park("two"));
        System.out.println("Park Two -> " + p.park("two"));

        System.out.println("Park Four -> " + p.park("four"));
        System.out.println("Park Four -> " + p.park("four"));
        System.out.println("Park Four -> " + p.park("four"));

        p.leave("two");
        System.out.println("One Two Wheeler Left");

        p.leave("four");
        System.out.println("One Four Wheeler Left");

        System.out.println("Park Two -> " + p.park("two"));

        System.out.println("\nFinal Two Wheelers : " + p.getTwoWheelers());
        System.out.println("Final Four Wheelers : " + p.getFourWheelers());
        System.out.println("Total Revenue : " + ParkingLot.getRevenue());
    }
}
