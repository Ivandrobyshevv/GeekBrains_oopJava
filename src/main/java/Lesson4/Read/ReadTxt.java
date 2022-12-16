package Lesson4.Read;
import Lesson4.Task;
import Lesson4.Tasks;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTxt {
    public static Tasks readBook (String pathName){
        Tasks readingBook = new Tasks();
        try (FileReader fr = new FileReader(pathName);) {
            Scanner scanner = new Scanner(fr);
            ArrayList<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
            for (String i:lines){
                int id = Integer.parseInt(i.substring(i.indexOf("=")+1, i.indexOf(",")));
                i = i.substring(i.indexOf(",")+1);
                LocalDate createDate = LocalDate.parse(i.substring(i.indexOf("=")+1, i.indexOf(",")));
                i = i.substring(i.indexOf(",")+1);
                LocalTime createTime = LocalTime.parse(i.substring(i.indexOf("=")+1, i.indexOf(",")));
                i = i.substring(i.indexOf(",")+1);
                LocalDate executeDate = LocalDate.parse(i.substring(i.indexOf("=")+1, i.indexOf(",")));
                i = i.substring(i.indexOf(",")+1);
                String firstName = i.substring(i.indexOf("=")+2, i.indexOf(",")-1);
                i = i.substring(i.indexOf(",")+1);
                String lastName = i.substring(i.indexOf("=")+2, i.indexOf(",")-1);
                i = i.substring(i.indexOf(",")+1);
                String urgencyString = i.substring(i.indexOf("=")+1, i.indexOf("}"));
                int urgencyInt = 1;
                switch (urgencyString){
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
                Task tempTask = new Task(id, urgencyInt, firstName,lastName,createDate,createTime);
                readingBook.addTask(tempTask);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readingBook;
    }
}
