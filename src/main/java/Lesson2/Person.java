package Lesson2;

public class Person {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected int age;

    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public int getId() {
        return this.id;
    }

    public String getFullName() {
        String fullName = firstUpperCase(this.firstName) + " " + firstUpperCase(this.lastName);
        return fullName;
    }

    public int getAge() {
        return this.age;
    }
}

class Teacher extends Person {
    public Teacher(int id, String firstName, String lastName, int age) {
        super(id, firstName, lastName, age);

    }
}

class Student extends Person {
    String status;

    public Student(int id, String firstName, String lastName, int age, String status) {
        super(id, firstName, lastName, age);
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}