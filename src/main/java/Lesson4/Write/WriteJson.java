package Lesson4.Write;

import Lesson4.Task;
import Lesson4.Tasks;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteJson {
    public void writeJson(JSONArray jsonArray, String pathFile){
        try (PrintWriter out = new PrintWriter(new FileWriter(pathFile))) {
            for (Object i : jsonArray){
                out.write(i.toString()+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONArray createJsonArray(Tasks tb){
        JSONArray resultArray = new JSONArray();
        for (Task i : tb.tasks){
            resultArray.add(createJsonObject(i));
        }
        return resultArray;
    }

    public Object createJsonObject(Task task){
        JSONObject resultObject = new JSONObject();
        resultObject.put("id",task.getId());
        resultObject.put("createDate",task.getCreateDate().toString());
        resultObject.put("createTime",task.getCreateTime().toString());
        resultObject.put("executeDate",task.getExecuteDate().toString());
        resultObject.put("firstNameCreator",task.getFirstNameCreator());
        resultObject.put("lastNameCreator",task.getLastNameCreator());
        resultObject.put("urgency",String.valueOf(task.getUrgency()));
        return resultObject;
    }
}
