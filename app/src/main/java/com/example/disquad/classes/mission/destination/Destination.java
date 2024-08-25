package com.example.disquad.classes.mission.destination;

import android.location.Location;

import com.example.disquad.classes.mission.attraction.Attraction;
import com.example.disquad.classes.squad.Squad;
import com.example.disquad.classes.squad.SquadMember;

import java.util.ArrayList;

public class Destination {
    // CLASS PROPERTIES
    private int destinationTypeID;
    private String destinationName;
    private ArrayList<Attraction> attractions;
    private Location location;
    private Squad squad;



    // CONSTRUCTORS
    public Destination(int destinationTypeID, String destinationName, Location location, Squad squad) {
        this.destinationTypeID = destinationTypeID;
        this.destinationName = destinationName;
        this.location = location;
        this.squad = squad;
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

    public Squad getSquad() {
        return this.squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }
}
