package Lesson3;

import java.util.ArrayList;
import java.util.List;

public class StudyGroup {
    String name;
    protected List<String> group = new ArrayList<>();

    public StudyGroup(String name) {
        this.name = name;
    }

    public void addUser(String user) {
        this.group.add(user);
    }

    public void printList() {
        int tmp = 0;
        for (String user : this.group) {
            tmp += 1;
            System.out.println(tmp + ") " + user);
        }
    }

    public String getName() {
        return this.name;
    }
}
