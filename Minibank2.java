
public class Minibank2 {

    static class Account {

        private final String accountNumber;
        private String ownerName;
        private long balance;
        private boolean active;

        private static int accountCounter = 1;

        private static String generateAccountNumber() {
            return String.format("AC%04d", accountCounter++);
        }

        public Account(String ownerName, long openingBalance) {
            this.accountNumber = generateAccountNumber();
            this.ownerName = ownerName;
            this.balance = openingBalance;
            this.active = true;
        }

        public Account(String ownerName) {
            this(ownerName, 0);
        }

        public void deposit(long amount) {
            balance += amount;
        }

        public boolean withdraw(long amount) {

            if (balance >= amount) {
                balance -= amount;
                return true;
            }

            return false;
        }

        public long getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {

        // Create account with opening balance 5000
        Account a = new Account("Sakshi", 5000);

        a.deposit(2000);
        System.out.println("Balance after deposit: " + a.getBalance());

        boolean result1 = a.withdraw(3000);
        System.out.println("Withdraw 3000: " + result1);
        System.out.println("Balance after withdraw: " + a.getBalance());

        boolean result2 = a.withdraw(10000);
        System.out.println("Withdraw 10000: " + result2);
        System.out.println("Balance after failed withdraw: " + a.getBalance());
    }
}
