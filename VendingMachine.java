
import java.util.Scanner;

public class VendingMachine {

    enum Coin {
        ONE, TWO, FIVE, TEN
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int price = 15;
        int total = 0;

        while (total < price) {

            System.out.print("enter coin (ONE, TWO, FIVE, TEN): ");
            String input = sc.nextLine().toUpperCase();

            Coin coin = Coin.valueOf(input);

            int value = switch (coin) {
                case ONE ->
                    1;
                case TWO ->
                    2;
                case FIVE ->
                    5;
                case TEN ->
                    10;
            };

            total = total + value;

            System.out.println("total so far: " + total);
        }

        System.out.println("paid. change: " + (total - price));

        sc.close();
    }
}
