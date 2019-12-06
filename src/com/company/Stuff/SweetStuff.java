package com.company.Stuff;

import java.io.Serializable;

public abstract class SweetStuff implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private float weight;
    private int price;

    public SweetStuff(String name, float weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SweetStuff{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
