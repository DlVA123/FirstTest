package com.AutoRia;

import java.io.FileWriter;
import java.io.IOException;

public class Car {
    private String name;
    private String run;
    private String price;


    public Car(String name, String run, String price) {
        this.name = name;
        this.run = run;
        this.price = price;
    }
    public void printName(){
        System.out.println(name);
    }
    public void printRun(){
        System.out.println(run );
    }
    public void printPrice(){
        System.out.println(price + "000 KM");
    }

    public void writeDate(String fileName,boolean reWriteData) {
        try(FileWriter writer = new FileWriter(fileName,reWriteData ))
        {
            writer.write(name+ "    ");
            writer.write(run + "    ");
            writer.write(price + "000 KM");
            writer.write("\n");
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
