package com.application.compbuilder;

public class Monitor {
    private String Name;
    private Double Price;
    private String screenSize;
    private String Resolution;
    private String refreshRate;
    private String responseTime;
    private String panelType;
    private String aspectRatio;

    public Monitor(String Name, Double Price, String screenSize, String Resolution, String refreshRate, String responseTime, String panelType,  String aspectRatio){
        this.Name = Name;
        this.Price = Price;
        this.screenSize = screenSize;
        this.Resolution = Resolution;
        this.refreshRate = refreshRate;
        this.responseTime = responseTime;
        this.panelType = panelType;
        this.aspectRatio = aspectRatio;

    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Double getPrice(){
        return Price;
    }

    public void setPrice(Double p){
        this.Price = p;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String ss) {
        this.screenSize = ss;
    }

    public String getResolution(){
        return Resolution;
    }

    public void setResolution(String r){
        this.Resolution = r;
    }

    public String getPanelType(){
        return panelType;
    }

    public void setPanelType(String pt){
        this.panelType = pt;
    }

    public String getRefreshRate(){
        return refreshRate;
    }

    public void setRefreshRate(String refRate){
        this.refreshRate = refRate;
    }

    public String getResponseTime(){
        return responseTime;
    }

    public void setResponseTime(String rt){
        this.responseTime = rt;
    }

    public String getAspectRatio(){
        return aspectRatio;
    }

    public void setAspectRatio(String ar){
        this.aspectRatio = ar;
    }
}
