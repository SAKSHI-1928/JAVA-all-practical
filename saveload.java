// 

import java.io.*;

class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    int marks;
    transient String password;

    Student(String name, int marks, String password) {
        this.name = name;
        this.marks = marks;
        this.password = password;
    }

    @Override
    public String toString() {
        return name + " | marks=" + marks + " | password=" + password;
    }
}

public class saveload {

    public static void main(String[] args) {
        String filename = "students.ser";

        Student[] list = {
            new Student("srusht", 95, "secret1"),
            new Student("sakshi", 90, "secret2"),
            new Student("koli", 97, "secret3")
        };

        System.out.println("=== Original Objects ===");
        java.util.Arrays.stream(list).forEach(System.out::println);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
            System.out.println("\nSuccessfully saved student array to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student[] restoredList = (Student[]) ois.readObject();

            System.out.println("\n=== Restored Objects ===");
            java.util.Arrays.stream(restoredList).forEach(System.out::println);
            System.out.println("\nNotice: 'password' field restored as 'null' because it is marked transient.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
