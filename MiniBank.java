
import java.util.Scanner;

public class MiniBank {

    record BankInfo(String name, String branch) {

    }

    enum MenuOption {
        OPEN_ACCOUNT,
        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        EXIT
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("MiniBank", "Anand Branch");

        System.out.println("==================================");
        System.out.println("      WELCOME TO " + bank.name());
        System.out.println("      Branch : " + bank.branch());
        System.out.println("==================================");

        while (true) {

            System.out.println("\n----- MAIN MENU -----");
            System.out.println("1. OPEN ACCOUNT");
            System.out.println("2. DEPOSIT");
            System.out.println("3. WITHDRAW");
            System.out.println("4. TRANSFER");
            System.out.println("5. EXIT");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid Choice! Please try again.");
                continue;
            }

            MenuOption option = MenuOption.values()[choice - 1];

            String message = switch (option) {

                case OPEN_ACCOUNT ->
                    "Open Account - To be implemented in a later lab.";

                case DEPOSIT ->
                    "Deposit - To be implemented in a later lab.";

                case WITHDRAW ->
                    "Withdraw - To be implemented in a later lab.";

                case TRANSFER ->
                    "Transfer - To be implemented in a later lab.";

                case EXIT ->
                    "Thank you for using MiniBank. Goodbye!";
            };

            System.out.println(message);

            if (option == MenuOption.EXIT) {
                break;
            }
        }

        sc.close();
    }
}
