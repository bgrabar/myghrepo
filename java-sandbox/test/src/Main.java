/**
 * Created by bob on 2016 /10/24.
 */

class Student {
    private String firstName;
    private String lastName;
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void printFullName() {
        System.out.println(firstName + " " + lastName);
    }
}

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[] {
            new Student("Joe", "Jones"),
            new Student("John", "Smith"),
            new Student("Anne", "Brown"),
        };
        for (Student s : students) {
            s.printFullName();
        }
    }
}
