package com.application.compbuilder;

public class Motherboard {
    private String Name;
    private Double Price;
    private String Socket;
    private String Memory;
    private int memorySlots;
    private String Colour;

    public Motherboard(String Name, Double Price, String Socket, String Memory, int memorySlots, String Colour) {
        this.Name = Name;
        this.Price = Price;
        this.Socket = Socket;
        this.Memory = Memory;
        this.memorySlots = memorySlots;
        this.Colour = Colour;
    }


    public String getName(){
        return Name;
    }

    public void setName(String pn){
        this.Name = pn;
    }

    public Double getPrice(){
        return Price;
    }

    public void setPrice(Double p){
        this.Price = p;
    }

    public String getSocket(){
        return Socket;
    }

    public void setSocket(String socket){
        this.Socket = socket;
    }

    public String getMemory(){
        return Memory;
    }

    public void setMemory(String memory){
        this.Memory = memory;
    }

    public int getMemorySlots(){
        return memorySlots;
    }

    public void setMemorySlots(int memorySlots){
        this.memorySlots = memorySlots;
    }

    public String getColour(){
        return Colour;
    }

    public void setColour(String colour){
        this.Colour = colour;
    }
}

