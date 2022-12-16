package Lesson4;

import Lesson4.Read.ReadJson;
import Lesson4.Read.ReadTxt;
import Lesson4.Write.WriteJson;
import Lesson4.Write.WriteTxt;

import java.util.logging.Logger;

public class Controller {
    public void start() {
        Logger logger = Logger.getAnonymousLogger();
        Task task1 = new Task(1, 1, "Ivan", "Ivanov");
        Task task2 = new Task(2, 1, "Ivan", "Ivanov");
        Task task3 = new Task(3, 2, "Ivan", "Ivanov");
        Task task4 = new Task(4, 2, "Ivan", "Ivanov");
        Task task5 = new Task(5, 3, "Petr", "Petrov");

        Tasks book1 = new Tasks();
        book1.addTask(task1);
        book1.addTask(task2);
        book1.addTask(task3);
        book1.addTask(task4);
        book1.addTask(task5);

        logger.info("\n" + book1.toString());
        new WriteTxt().write(book1, "src/main/java/Lesson4/book1.txt");
        logger.info("\n" + new ReadTxt().readBook("src/main/java/Lesson4/book1.txt").toString());

        WriteJson writer = new WriteJson();
        writer.writeJson(writer.createJsonArray(book1), "src/main/java/Lesson4/book1.json");
        ReadJson jsonReader = new ReadJson();
        Tasks book2 = jsonReader.readJson("src/main/java/Lesson4/book1.json");
        logger.info("\n" + book2.toString());
    }
}
