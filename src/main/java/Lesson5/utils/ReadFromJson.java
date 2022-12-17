package Lesson5.utils;

import Lesson5.Model.Contact.Contact;
import Lesson5.Model.Contact.Phone;
import Lesson5.Model.Contact.User;
import Lesson5.Model.Phonebook.Phonebook;
import Lesson5.Model.Service.ContactServiceImpl;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromJson {
    public Phonebook readJson(String pathFile){
        Phonebook resultBook = new Phonebook(pathFile.substring(pathFile.lastIndexOf("/")+1 , pathFile.lastIndexOf(".")));
        try (FileReader fr = new FileReader(pathFile)){
            Scanner scanner = new Scanner(fr);
            JSONParser parser = new JSONParser();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                JSONObject object = (JSONObject) parser.parse(line);
                resultBook.addContact(JsonToContact(object));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBook;
    }

    public Contact JsonToContact(JSONObject line){
        User user = new User(line.get("firstName").toString(), line.get("lastName").toString());
        String phonesLine = line.get("Phones").toString();
        phonesLine = phonesLine.replace("[","").replace("]","");
        String[] phonesArray = phonesLine.split(",");
        ArrayList<Phone> phones = new ArrayList<>();
        for (String i: phonesArray){
            phones.add(new Phone(i));
        }
        return new ContactServiceImpl().createContact(user, phones);
    }
}
