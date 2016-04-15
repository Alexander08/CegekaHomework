package ro.cegeka.homework.hw1.main;

import ro.cegeka.homework.hw1.bridge.refinedAbstraction.Candy;

import java.util.Date;

/**
 * Created by John Smith on 15.04.2016.
 */
public class Main {
    public static void main(String[] args) {

        Candy candy = new Candy("bomboana", "rotunda", Double.valueOf(10), Double.valueOf(25), new Date(), "txt");

        candy.save();

        Candy candy2 = new Candy("bomboana", "rotunda", Double.valueOf(10), Double.valueOf(25), new Date(), "xml");

        candy2.save();

        Candy candy3 = new Candy("bomboana", "rotunda", Double.valueOf(10), Double.valueOf(25), new Date(), "json");

        candy3.save();

    }
}
