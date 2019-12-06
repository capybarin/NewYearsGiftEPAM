package com.company;

import com.company.Stuff.ChocolateBar;
import com.company.Stuff.Cookies;
import com.company.Stuff.Doughnuts;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final String COOKIES_FILE = "src/com/company/Data/inCookies.txt";
    public static final String DOUGHNUTS_FILE = "src/com/company/Data/inDoughnuts.txt";
    public static final String CHOCOLATE_FILE = "src/com/company/Data/inChocolateBar.txt";
    public static final String COOKIES_PATH = "src/com/company/Data/Cookies.ser";
    public static final String CHOCOLATE_PATH = "src/com/company/Data/Chocolate.ser";
    public static final String DOUGHNUT_PATH = "src/com/company/Data/Doughnut.ser";

    public static void main(String[] args) {
        ArrayList<Cookies> cookiesArrayList = new ArrayList<>();
        ArrayList<Doughnuts> doughnutsArrayList = new ArrayList<>();
        ArrayList<ChocolateBar> chocolateBarArrayList = new ArrayList<>();

        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(COOKIES_FILE));
            String line;
            String tmpLine;
            String tmpNxtLine = null;
            while ((line = reader.readLine())!=null){
                StringTokenizer str = new StringTokenizer(line," ");
                tmpLine = line.substring(0, line.indexOf(' '));
                if(!tmpLine.equals(tmpNxtLine)){
                    tmpNxtLine = tmpLine;
                    while(str.hasMoreTokens()){
                        Cookies cookies = new Cookies(str.nextToken(), Float.valueOf(str.nextToken()),
                                Integer.valueOf(str.nextToken()));
                        cookiesArrayList.add(cookies);
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            reader = new BufferedReader(new FileReader(DOUGHNUTS_FILE));
            String line;
            String tmpLine;
            String tmpNxtLine = null;
            while ((line = reader.readLine())!=null){
                StringTokenizer str = new StringTokenizer(line," ");
                tmpLine = line.substring(0, line.indexOf(' '));
                if(!tmpLine.equals(tmpNxtLine)){
                    tmpNxtLine = tmpLine;
                    while(str.hasMoreTokens()){
                        Doughnuts doughnuts = new Doughnuts(str.nextToken(), Float.valueOf(str.nextToken()),
                                Integer.valueOf(str.nextToken()));
                        doughnutsArrayList.add(doughnuts);
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            reader = new BufferedReader(new FileReader(CHOCOLATE_FILE));
            String line;
            String tmpLine;
            String tmpNxtLine = null;
            while ((line = reader.readLine())!=null){
                StringTokenizer str = new StringTokenizer(line," ");
                tmpLine = line.substring(0, line.indexOf(' '));
                if(!tmpLine.equals(tmpNxtLine)){
                    tmpNxtLine = tmpLine;
                    while(str.hasMoreTokens()){
                        ChocolateBar chocolateBar = new ChocolateBar(str.nextToken(), Float.valueOf(str.nextToken()),
                                Integer.valueOf(str.nextToken()));
                        chocolateBarArrayList.add(chocolateBar);
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectOutputStream objectOutputStreamCookies;
        ObjectOutputStream objectOutputStreamDoughnut;
        ObjectOutputStream objectOutputStreamChocolate;
        try {
            objectOutputStreamCookies = new ObjectOutputStream(new FileOutputStream(COOKIES_PATH));
            objectOutputStreamDoughnut = new ObjectOutputStream(new FileOutputStream(DOUGHNUT_PATH));
            objectOutputStreamChocolate = new ObjectOutputStream(new FileOutputStream(CHOCOLATE_PATH));
            for (Cookies c:cookiesArrayList) {
                objectOutputStreamCookies.writeObject(c);
            }
            for (Doughnuts d:doughnutsArrayList) {
                objectOutputStreamDoughnut.writeObject(d);
            }
            for (ChocolateBar ch:chocolateBarArrayList) {
                objectOutputStreamChocolate.writeObject(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NYGift nyGift = new NYGift(cookiesArrayList, doughnutsArrayList, chocolateBarArrayList);
        ArrayList<Object> present = new ArrayList<>();
        present.addAll(nyGift.getPresent());
        //System.out.println(present);


        /**
         * 1 - sort by name
         * 2 - sort by price
         * 3 - sort by weight
         * otherwise - oops
         */
        nyGift.sort(cookiesArrayList, doughnutsArrayList, chocolateBarArrayList, 1);
    }
}
