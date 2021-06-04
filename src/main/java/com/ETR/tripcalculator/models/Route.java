package com.ETR.tripcalculator.models;

public class Route {
    int toId;
    double distance;
    boolean enter;
    boolean exit;
    String startDate;


    public Route() {
    }

    public Route(int toId, double distance, boolean enter, boolean exit, String startDate) {
        this.toId = toId;
        this.distance = distance;
        this.enter = enter;
        this.exit = exit;
        this.startDate = startDate;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isEnter() {
        return enter;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
