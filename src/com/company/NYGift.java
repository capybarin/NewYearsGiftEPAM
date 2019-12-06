package com.company;

import com.company.Stuff.ChocolateBar;
import com.company.Stuff.Cookies;
import com.company.Stuff.Doughnuts;
import com.company.Stuff.SweetStuff;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class NYGift implements Serializable {
    private ArrayList<Cookies> cookies;
    private ArrayList<Doughnuts> doughnuts;
    private ArrayList<ChocolateBar> chocolateBars;

    public NYGift(ArrayList<Cookies> cookies, ArrayList<Doughnuts> doughnuts, ArrayList<ChocolateBar> chocolateBars) {
        this.cookies = cookies;
        this.doughnuts = doughnuts;
        this.chocolateBars = chocolateBars;
    }

    private float getWeight(){
        float sum = 0L;
        for (Cookies c:cookies) {
            sum+=c.getWeight();
        }
        for (Doughnuts d:doughnuts) {
            sum+=d.getWeight();
        }
        for (ChocolateBar ch:chocolateBars) {
            sum+=ch.getWeight();
        }
        return sum;
    }

    public ArrayList<Object> getPresent(){
        ArrayList<Object> present = new ArrayList<>();
        present.addAll(cookies);
        present.addAll(doughnuts);
        present.addAll(chocolateBars);
        return present;
    }

    public void sort(ArrayList<Cookies> cookies, ArrayList<Doughnuts> doughnuts, ArrayList<ChocolateBar> chocolateBar,int i){
        switch (i){
            default: {
                System.out.println("Oops");
            }break;
            case 1:{
                cookies.sort(Comparator.comparing(Cookies::getName));
                doughnuts.sort(Comparator.comparing(Doughnuts::getName));
                chocolateBar.sort(Comparator.comparing(ChocolateBar::getName));
            }break;
            case 2:{
                cookies.sort(Comparator.comparing(Cookies::getPrice));
                doughnuts.sort(Comparator.comparing(Doughnuts::getPrice));
                chocolateBar.sort(Comparator.comparing(ChocolateBar::getPrice));
            }break;
            case 3:{
                cookies.sort(Comparator.comparing(Cookies::getWeight));
                doughnuts.sort(Comparator.comparing(Doughnuts::getWeight));
                chocolateBar.sort(Comparator.comparing(ChocolateBar::getWeight));
            }break;
        }
        ArrayList<SweetStuff> present = new ArrayList<>();
        present.addAll(cookies);
        present.addAll(doughnuts);
        present.addAll(chocolateBars);
        present.forEach((n) -> System.out.println(n));
    }
}
