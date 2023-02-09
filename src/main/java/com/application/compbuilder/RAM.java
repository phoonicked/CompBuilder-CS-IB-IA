package com.application.compbuilder;

public class RAM {
    private String Name;
    private Double Price;
    private String Speed;
    private String Module;
    private String Colour;
    private String firstWordLatency;
    private int casLatency;

    public RAM(String Name, Double Price, String Speed, String Module, String Colour, String firstWordLatency, Integer casLatency) {
        this.Name = Name;
        this.Price = Price;
        this.Speed = Speed;
        this.Module = Module;
        this.Colour = Colour;
        this.firstWordLatency = firstWordLatency;
        this.casLatency = casLatency;
    }


    public String getName(){
        return Name;
    }

    public void setName(String name){
        this.Name = name;
    }

    public Double getPrice(){
        return Price;
    }

    public void setPrice(Double p){
        this.Price = p;
    }

    public String getSpeed(){
        return Speed;
    }

    public void setSpeed(String speed){
        this.Speed = speed;
    }

    public String getModule(){
        return Module;
    }

    public void setModule(String m){
        this.Module = m;
    }

    public String getColour(){
        return Colour;
    }

    public void setColour(String col){
        this.Colour = col;
    }

    public String getFirstWordLatency(){
        return firstWordLatency;
    }

    public void setFirstWordLatency(String fwl){
        this.firstWordLatency = fwl;
    }
    public int getCasLatency(){
        return casLatency;
    }

    public void setCasLatency(int cas){
        this.casLatency = cas;
    }
}
