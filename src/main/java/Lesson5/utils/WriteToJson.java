package Lesson5.utils;

import Lesson5.Model.Contact.Contact;
import Lesson5.Model.Phonebook.Phonebook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteToJson {
    public void writeJson(JSONArray jsonArray, String pathFile){
        try (PrintWriter out = new PrintWriter(new FileWriter(pathFile))) {
            for (Object i : jsonArray){
                out.write(i.toString()+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONArray createJsonArray(Phonebook pb){
        JSONArray resultArray = new JSONArray();
        ArrayList<Contact> contactsList = pb.getContacts();
        for (Contact i : contactsList){
            resultArray.add(createJsonObject(i));
        }
        return resultArray;
    }

    public JSONObject createJsonObject(Contact contact){
        JSONObject resultObject = new JSONObject();
        resultObject.put("firstName",contact.getUser().getFirstName());
        resultObject.put("lastName",contact.getUser().getLastName());
        resultObject.put("Phones",contact.getPhones());
        return resultObject;
    }
}
