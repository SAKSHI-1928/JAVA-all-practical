import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank
    String name;

    @NotBlank
    @MaxLength(10)
    String password;

    @MaxLength(30)
    String email;

    SignupForm(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}

public class formvalidator {

    static List<String> check(SignupForm form) {
        List<String> errors = new ArrayList<>();

        for (Field f : form.getClass().getDeclaredFields()) {
            try {
                f.setAccessible(true);
                Object value = f.get(form);

                if (f.isAnnotationPresent(NotBlank.class)) {
                    if (value == null || value.toString().trim().equals("")) {
                        errors.add(f.getName() + " is blank");
                    }
                }

                if (f.isAnnotationPresent(MaxLength.class)) {
                    MaxLength m = f.getAnnotation(MaxLength.class);

                    if (value != null && value.toString().length() > m.value()) {
                        errors.add(f.getName() + " is too long");
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return errors;
    }

    public static void main(String[] args) {

        SignupForm form =
                new SignupForm("", "abcdefghijklm", "abc@gmail.com");

        List<String> errors = check(form);

        if (errors.size() == 0) {
            System.out.println("Valid form");
        } else {
            for (String s : errors) {
                System.out.println(s);
            }
        }
    }
}