package ro.cegeka.homework.hw1.bridge.concreteImplementor;

import ro.cegeka.homework.hw1.bridge.implementor.SaveFormat;

import java.io.*;
import java.util.Date;

/**
 * Created by John Smith on 14.04.2016.
 */
public class SaveFormatTXT implements SaveFormat {

    public void printObject(String name, String form, Double price, Double weight, Date expireDate) {

        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("candy.txt"), "utf-8"));

            writer.write("Candy name: " + name + "\n");
            writer.write("Candy form: " + form + "\n");
            writer.write("Candy price: " + price.toString() + "\n");
            writer.write("Candy weight: " + weight.toString() + "\n");
            writer.write("Candy expire date: " + expireDate.toString() + "\n");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                writer.close();
                System.out.println("File saved!");
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
