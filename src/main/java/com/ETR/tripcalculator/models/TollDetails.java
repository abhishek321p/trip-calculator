package com.ETR.tripcalculator.models;

public class TollDetails {
    double distance;
    double price;

    private TollDetails(double distance, double price) {
        this.distance = distance;
        this.price = price;
    }

    private TollDetails(){};

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static TollDetails create(double distance, double price){
        return new TollDetails(distance, price);
    }
}
