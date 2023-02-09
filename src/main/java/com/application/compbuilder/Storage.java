package com.application.compbuilder;

public class Storage {
    private String Name;
    private Double Price;
    private String Capacity;
    private String Type;
    private String Cache;
    private String formFactor;
    private String Interface;

    public Storage(String Name, Double Price, String Capacity, String Type, String Cache, String Interface) {
        this.Name = Name;
        this.Price = Price;
        this.Capacity = Capacity;
        this.Type = Type;
        this.Cache = Cache;
        this.Interface = Interface;
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

    public String getCapacity() {return Capacity;}

    public void setCapacity(String cap){
        this.Capacity = cap;
    }

    public String getType(){
        return Type;
    }

    public void setType(String type){
        this.Type = type;
    }

    public String getCache(){
        return Cache;
    }

    public void setCache(String cache){
        this.Cache = cache;
    }

    public String getInterface(){
        return Interface;
    }

    public void setInterface(String intface){
        this.Interface = intface;
    }
}
