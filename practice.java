import java.io.*;
import java.util.*;

class Student implements Serializable {
    private String name, email;
    private int age;

    public Student(String n, String e, int a) {
        this.name = n;
        this.age = a;
        this.email = e;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getAge() {
        return this.age;
    }
}

public class practice {
    public static void main(String args[]) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Saurabh Wagh", "waghsa1@rknec.edu", 20));
        studentList.add(new Student("Rashmi Kanharkar", "kanharkarrm@rknec.edu", 19));

        try (FileOutputStream fo = new FileOutputStream("file.txt");
             ObjectOutputStream obs = new ObjectOutputStream(fo)) {

            for (Student student : studentList) {
                obs.writeObject(student);
                System.out.println("Written: " + student.getName());
            }

            System.out.println("Done writing");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream finput = new FileInputStream("file.txt");
             ObjectInputStream ois = new ObjectInputStream(finput)) {

            while (true) {
                try {
                    Student sdash = (Student) ois.readObject();
                    System.out.println("Read: " + sdash.getName());
                } catch (EOFException e) {
                    // Reached end of file
                    break;
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
