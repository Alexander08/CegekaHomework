package ro.cegeka.homework.hw2.adapter;

/**
 * Created by John Smith on 15.04.2016.
 */

import java.util.Date;

/**
 * Created by John Smith on 15.04.2016.
 */
public abstract class Candy{

    protected String name;
    protected String form;
    protected Double price;
    protected Double weight;
    protected Date expireDate;

    public Candy() {
    }

    public Candy(String name, String form, Double price, Double weight, Date expireDate) {

        this.name = name;
        this.form = form;
        this.price = price;
        this.weight = weight;
        this.expireDate = expireDate;
    }

    public String getName() {
        return name;
    }

    public Candy setName(String name) {
        this.name = name;
        return this;
    }

    public String getForm() {
        return form;
    }

    public Candy setForm(String form) {
        this.form = form;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Candy setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public Candy setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Candy setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
        return this;
    }
}
