package Lesson4.Write;

import Lesson4.Tasks;

import java.io.FileWriter;
import java.io.IOException;

public class WriteTxt {
    public static void write(Tasks taskBook, String pathFile) {
        try (FileWriter fw = new FileWriter(pathFile, false)) {
            for (int i = 0; i < taskBook.tasks.size(); i++) {
                fw.write(taskBook.tasks.get(i).toString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
