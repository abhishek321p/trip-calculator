package com.ETR.tripcalculator.models;

import java.util.Map;

public class Locations {
    Map<Integer, Location> locations;

    public Locations() {
    }

    public Locations(Map<Integer, Location> locations) {
        this.locations = locations;
    }

    public Map<Integer, Location> getLocations() {
        return locations;
    }

    public void setLocations(Map<Integer, Location> locations) {
        this.locations = locations;
    }
}
