package Lesson2;

import java.io.FileNotFoundException;

public class DataService {
    public static void main(String[] args) throws FileNotFoundException {
        TrainingGroupService groupService = new TrainingGroupService();
        groupService.read("src/main/java/Lesson2/users.txt");
        groupService.displayGroup();


    }

}

