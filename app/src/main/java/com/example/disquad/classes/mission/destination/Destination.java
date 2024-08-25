package com.example.disquad.classes.mission.destination;

import android.location.Location;

import com.example.disquad.classes.mission.attraction.Attraction;

import java.util.ArrayList;

public class Destination {
    // CLASS PROPERTIES
    private int destinationTypeID;
    private String destinationName;
    private ArrayList<Attraction> attractions;
    private Location location;



    // CONSTRUCTORS
    public Destination(int destinationTypeID, String destinationName, Location location) {
        this.destinationTypeID = destinationTypeID;
        this.destinationName = destinationName;
        this.location = location;
    }



    // GETTERS / SETTERS
    public int getDestinationTypeID() {
        return this.destinationTypeID;
    }

    public void setDestinationTypeID(int destinationTypeID) {
        this.destinationTypeID = destinationTypeID;
    }

    public String getDestinationName() {
        return this.destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public ArrayList<Attraction> getAttractions() {
        return this.attractions;
    }

    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
