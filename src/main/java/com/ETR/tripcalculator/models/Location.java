package com.ETR.tripcalculator.models;

import java.util.List;

public class Location {
    String name;
    double lat;
    double lng;
    List<Route> routes;
    String devcomment;

    public Location() {
    }

    public Location(String name, double lat, double lng, List<Route> routes, String devcomment) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.routes = routes;
        this.devcomment = devcomment;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getDevcomment() {
        return devcomment;
    }

    public void setDevcomment(String devcomment) {
        this.devcomment = devcomment;
    }
}
