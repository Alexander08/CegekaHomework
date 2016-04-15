package ro.cegeka.homework.hw1.bridge.implementor;

import java.util.Date;

/**
 * Created by John Smith on 14.04.2016.
 */
public interface SaveFormat {

    public void printObject( String name, String form, Double price, Double weight, Date expireDate);
}
