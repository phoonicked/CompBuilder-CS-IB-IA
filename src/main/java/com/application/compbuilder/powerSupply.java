package com.application.compbuilder;

    public class powerSupply {
        private String Name;
        private Double Price;
        private String Wattage;
        private String Modular;
        private String Colour;

        public powerSupply(String Name, Double Price, String Wattage, String Modular, String Colour) {
            this.Name = Name;
            this.Price = Price;
            this.Wattage = Wattage;
            this.Modular = Modular ;
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

        public String getWattage(){
            return Wattage;
        }

        public void setWattage(String watt){
            this.Wattage = watt;
        }
        public String getModular(){
            return Modular;
        }

        public void setModular(String modular){
            this.Modular = modular;
        }

        public String getColour(){
            return Colour;
        }

        public void setColour(String colour){
            this.Colour = colour;
        }
    }

