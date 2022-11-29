package Lesson2;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainingGroupService {
    List<StudyGroup> groups = new ArrayList<>();

    public Teacher createTeacher(String teacher) {
        String[] items = teacher.split(",");
        String[] nameAndSurname = items[1].split(" ");
        int id = Integer.valueOf(items[0]);
        String firstName = nameAndSurname[0];
        String lastName = nameAndSurname[1];
        int age = Integer.valueOf(items[2]);
        Teacher newTeacher = new Teacher(id, firstName, lastName, age);
        return newTeacher;
    }

    public List<Student> createStudent(String students) {
        List<Student> listResult = new ArrayList<>();
        String[] listStudents = students.split(", ");

        for (String user : listStudents) {
            String[] items = user.split(",");
            String[] nameAndSurname = items[1].split(" ");
            int id = Integer.valueOf(items[0]);
            String firstName = nameAndSurname[0];
            String lastName = nameAndSurname[1];
            int age = Integer.valueOf(items[2]);
            String status = items[3];
            Student student = new Student(id, firstName, lastName, age, status);
            listResult.add(student);
        }
        return listResult;
    }

    public void read(String fileName) throws FileNotFoundException {
        try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
            String line;
            int temp = 1;
            Teacher newTeacher = null;
            while ((line = file.readLine()) != null) {
                if (temp % 2 != 0) {
                    String teacher = line;
                    newTeacher = createTeacher(teacher);
                } else {
                    String students = line;
                    List<Student> list = createStudent(students);
                    initList(newTeacher, list);
                }
                temp += 1;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void initList(Teacher teacher, List<Student> list) {
        StudyGroup group = new StudyGroup(teacher, list);
        groups.add(group);
    }

    public void displayGroup() {
        for (StudyGroup group : groups) {
            System.out.println("---------------------");
            System.out.println("Преподаватель:");
            group.displayTeacher();
            System.out.println("Студенты: ");
            group.displayStudent();
            System.out.println("---------------------");
        }
    }

}
