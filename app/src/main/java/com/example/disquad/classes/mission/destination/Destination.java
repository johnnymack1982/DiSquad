package com.example.disquad.classes.mission.destination;

import com.example.disquad.classes.mission.attraction.Attraction;

import java.util.ArrayList;

public class Destination {
    // CLASS PROPERTIES
    private int destinationTypeID;
    private String destinationName;
    private ArrayList<Attraction> attractions;



    // CONSTRUCTORS
    public Destination(int destinationTypeID, String destinationName) {
        this.destinationTypeID = destinationTypeID;
        this.destinationName = destinationName;
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
}
