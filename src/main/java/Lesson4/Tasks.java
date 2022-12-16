package Lesson4;

import java.util.ArrayList;

public class Tasks {
    public ArrayList<Task> tasks;

    public Tasks() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Task i : this.tasks) {
            sb.append(i + "\n");
        }
        return sb.toString();
    }
}
