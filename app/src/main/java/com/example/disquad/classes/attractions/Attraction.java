package com.example.disquad.classes.attractions;

import android.location.Location;

public class Attraction {
    // CLASS PROPERTIES
    private String attractionName;
    private Location attractionLocation;



    // CONSTRUCTORS
    public Attraction(String attractionName, Location attractionLocation) {
        this.attractionName = attractionName;
        this.attractionLocation = attractionLocation;
    }



    // GETTERS / SETTERS
    public String getAttractionName() {
        return this.attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public Location getAttractionLocation() {
        return this.attractionLocation;
    }

    public void setAttractionLocation(Location attractionLocation) {
        this.attractionLocation = attractionLocation;
    }
}
