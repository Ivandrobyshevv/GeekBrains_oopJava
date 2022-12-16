package Lesson4.Read;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import Lesson4.Task;
import Lesson4.Tasks;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJson {
    public Tasks readJson(String pathFile){
        Tasks resultBook = new Tasks();
        try (FileReader fr = new FileReader(pathFile)){
            Scanner scanner = new Scanner(fr);
            JSONParser parser = new JSONParser();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                JSONObject object = (JSONObject) parser.parse(line);
                resultBook.addTask(JsonToTask(object));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBook;
    }

    public Task JsonToTask(JSONObject line){
        Integer urgencyInt = 1;
        switch (line.get("urgency").toString()){
            case "Low":
                urgencyInt = 1;
                break;
            case "Medium":
                urgencyInt = 2;
                break;
            case "Immediately":
                urgencyInt = 3;
                break;
        }
        return new Task(Integer.parseInt(line.get("id").toString()),urgencyInt, line.get("firstNameCreator").toString(),
                line.get("lastNameCreator").toString(), LocalDate.parse(line.get("createDate").toString()),
                LocalTime.parse(line.get("createTime").toString()));
    }
}
