package com.application.compbuilder;

import java.time.Month;

public class savedBuild {
    private String CPU;
    private String RAM;
    private String Motherboard;
    private String powerSupply;
    private String Storage;
    private String GPU;
    private String Monitor;
    private Double totalPrice;

    public savedBuild(String CPU, String RAM, String Motherboard, String powerSupply, String Storage, String GPU, String Monitor, Double totalPrice) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.Motherboard = Motherboard;
        this.powerSupply = powerSupply;
        this.Storage = Storage;
        this.GPU = GPU;
        this.Monitor = Monitor;
        this.totalPrice= totalPrice;
    }

    public String getCPU(){
        return CPU;
    }

    public void setCPU(String cpu){
        this.CPU = cpu;
    }

    public String getRAM(){
        return RAM;
    }

    public void setRAM(String ram){
        this.RAM = ram;
    }

    public String getMotherboard(){
        return Motherboard;
    }

    public void setMotherboard(String motherboard){
        this.Motherboard = motherboard;
    }

    public String getPowerSupply(){
        return powerSupply;
    }

    public void setPowerSupply(String ps){
        this.powerSupply = ps;
    }

    public String getStorage(){
        return Storage;
    }

    public void setStorage(String storage){
        this.Storage = storage;
    }

    public String getGPU(){
        return GPU;
    }

    public void setGPU(String gpu){
        this.GPU = gpu;
    }

    public String getMonitor(){
        return Monitor;
    }

    public void setMonitor(String monitor){
        this.Monitor = monitor;
    }

    public Double getPrice(){
        return totalPrice;
    }

    public void setPrice(Double p){
        this.totalPrice = p;
    }
}
