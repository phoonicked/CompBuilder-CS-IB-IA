package com.application.compbuilder;

public class CPU {
    private String Name;
    private Double Price;
    private String coreCount;
    private String coreClock;
    private String boostClock;
    private String tdp;
    private String integratedGraphics;
    private String smt;

    public CPU(String Name, Double Price, String coreCount, String coreClock , String boostClock, String tdp, String integratedGraphics, String smt) {
        this.Name = Name;
        this.Price = Price;
        this.coreCount = coreCount;
        this.coreClock = coreClock;
        this.boostClock = boostClock;
        this.tdp = tdp;
        this.integratedGraphics = integratedGraphics;
        this.smt = smt;
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

    public String getCoreCount(){
        return coreCount;
    }

    public void setCoreCount(String cc){
        this.coreCount = cc;
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

    public String getTdp(){
        return tdp;
    }

    public void setTdp(String tdp){
        this.tdp = tdp;
    }

    public String getIntegratedGraphics(){
        return integratedGraphics;
    }

    public void setIntegratedGraphics(String ig){
        this.integratedGraphics = ig;
    }

    public String getSmt(){
        return smt;
    }

    public void setSmt(String smt){
        this.smt = smt;
    }
}
