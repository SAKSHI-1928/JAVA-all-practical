
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String pw = sc.nextLine();

        System.out.println("\nRules Passed:");

        if (pw.length() >= 8) {
            System.out.println("Done: Length >= 8");
        } else {
            System.out.println("wrong: Length >= 8");
        }

        boolean upper = false;
        boolean digit = false;
        boolean special = false;

        for (int i = 0; i < pw.length(); i++) {
            char ch = pw.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                upper = true;
            } else if (ch >= '0' && ch <= '9') {
                digit = true;
            } else if (!((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))) {
                special = true;
            }
        }

        if (upper) {
            System.out.println("Pass: Contains Uppercase");
        } else {
            System.out.println("Fail: Contains Uppercase");
        }

        if (digit) {
            System.out.println("Pass: Contains Digit");
        } else {
            System.out.println("Fail: Contains Digit");
        }

        if (special) {
            System.out.println("Pass: Contains Special Character");
        } else {
            System.out.println("Fail: Contains Special Character");
        }

        System.out.println("\nPassword Strength: " + PasswordChecker.strength(pw));

        sc.close();
    }
}
