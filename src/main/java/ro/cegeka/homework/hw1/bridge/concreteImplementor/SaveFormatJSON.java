package ro.cegeka.homework.hw1.bridge.concreteImplementor;

import org.json.simple.JSONObject;
import ro.cegeka.homework.hw1.bridge.implementor.SaveFormat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by John Smith on 14.04.2016.
 */
public class SaveFormatJSON implements SaveFormat {

    public void printObject(String name, String form, Double price, Double weight, Date expireDate) {

        JSONObject obj = new JSONObject();

        obj.put("Name", name);
        obj.put("Form", form);
        obj.put("Price", price);
        obj.put("Weight", weight);
        obj.put("Expire Date", expireDate.toString());

        try  {
            FileWriter file = new FileWriter("candy.json");
            file.write(obj.toJSONString());
            file.close();
            System.out.println("File saved!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}