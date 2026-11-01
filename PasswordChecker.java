
public class PasswordChecker {

    public static boolean isValid(String pw) {

        boolean upper = false;
        boolean digit = false;
        boolean special = false;

        if (pw.length() < 8) {
            return false;
        }

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

        return upper && digit && special;
    }

    public static String strength(String pw) {

        int count = 0;

        if (pw.length() >= 8) {
            count++;
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
            count++;
        }

        if (digit) {
            count++;
        }

        if (special) {
            count++;
        }

        if (count <= 1) {
            return "Weak";
        } else if (count <= 3) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}
