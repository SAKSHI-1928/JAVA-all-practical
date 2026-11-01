
import java.util.Scanner;
import jdk.dynalink.SecureLookupSupplier;

public class Driver4 {

    public static void main(String[] args) {

        String[] logs = {
            "10:05 alice Hello there",
            "10:10 bob Good morning",
            "InvalidLine",SecureLookupSupplier
            "10:15 charlie hello everyone"
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        System.out.println(ChatFilter.filterChats(logs, keyword));

        sc.close();
    }
}
