package Lesson2;

import java.util.ArrayList;
import java.util.List;

public class StudyGroup {
    protected Teacher teacher;
    protected ArrayList<Student> students = new ArrayList<Student>();


    public StudyGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        for (Student student : students) {
            this.students.add(student);
        }

    }

    public void displayTeacher() {
        System.out.println("ID: " + teacher.getId() + "\nФИО: " +
                teacher.getFullName() + "\nВозраст: " + teacher.getAge());
    }

    public void displayStudent() {
        if (students.size() > 0) {
            for (Student student : students) {
                System.out.println(
                        "ID: " + student.getId() +
                        "\nФИО: " + student.getFullName() +
                                "\nВозраст: " + student.getAge() +
                                "\nФорма обучения: " + student.getStatus()
                );
            }
        }

    }
}
