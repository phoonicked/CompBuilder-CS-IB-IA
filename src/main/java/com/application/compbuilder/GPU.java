package com.application.compbuilder;

import javafx.scene.control.Button;

public class GPU {
    private String Name;
    private Double Price;
    private String Chipset;
    private String Memory;
    private String coreClock;
    private String boostClock;
    private String Colour;
    private String Length;

    public GPU(String Name, Double Price, String Chipset, String Memory, String coreClock, String boostClock, String Colour, String Length) {
        this.Name = Name;
        this.Price = Price;
        this.Chipset = Chipset;
        this.Memory = Memory;
        this.coreClock = coreClock;
        this.boostClock = boostClock;
        this.Colour = Colour;
        this.Length = Length;
    }

    public String getName(){
        return Name;
    }

    public void setName(String nm){
        this.Name = nm;
    }

    public Double getPrice(){
        return Price;
    }

    public void setPrice(Double p){
        this.Price = p;
    }

    public String getChipset(){
        return Chipset;
    }

    public void setChipset(String chipset){
        this.Chipset = chipset;
    }

    public String getMemory(){
        return Memory;
    }

    public void setMemory(String mem){
        this.coreClock = mem;
    }

    public String getCoreClock(){
        return coreClock;
    }

    public void setCoreClock(String cclock){
        this.coreClock = cclock;
    }

    public String getBoostClock(){
        return boostClock;
    }

    public void setBoostClock(String bc){
        this.boostClock = bc;
    }

    public String getColour(){
        return Colour;
    }

    public void setColour(String col){
        this.Colour = col;
    }

    public String getLength(){
        return Length;
    }

    public void setLength(String length){
        this.Length = length;
    }
}
