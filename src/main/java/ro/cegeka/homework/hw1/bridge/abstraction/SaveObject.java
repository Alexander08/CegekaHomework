package ro.cegeka.homework.hw1.bridge.abstraction;

import ro.cegeka.homework.hw1.bridge.implementor.SaveFormat;
import ro.cegeka.homework.hw1.bridge.concreteImplementor.SaveFormatJSON;
import ro.cegeka.homework.hw1.bridge.concreteImplementor.SaveFormatTXT;
import ro.cegeka.homework.hw1.bridge.concreteImplementor.SaveFormatXML;

/**
 * Created by John Smith on 14.04.2016.
 */
public abstract class SaveObject{

    protected SaveFormat saveFormat;

    public SaveObject() {
    }

    public SaveObject(SaveFormat saveFormat) {
        this.saveFormat = saveFormat;
    }

    public SaveObject(String format) {

        String s = format.toLowerCase();
        if (s.equals("txt")) {
            this.saveFormat = new SaveFormatTXT();

        } else if (s.equals("json")) {
            this.saveFormat = new SaveFormatJSON();

        } else if (s.equals("xml")) {
            this.saveFormat = new SaveFormatXML();

        } else {
            System.out.println("Invalid Format!");

        }
    }

    public SaveFormat getSaveFormat() {
        return saveFormat;
    }

    public SaveObject setSaveFormat(SaveFormat saveFormat) {
        this.saveFormat = saveFormat;
        return this;
    }

    abstract public void save();
}
