package com.example.disquad.classes.mission.attraction;

import android.location.Location;

import com.example.disquad.classes.squad.SquadMember;

import java.util.ArrayList;

public class Attraction {
    // CLASS PROPERTIES
    private String attractionName;
    private Location attractionLocation;
    private ArrayList<SquadMember> participants;



    // CONSTRUCTORS
    public Attraction(String attractionName, Location attractionLocation, ArrayList<SquadMember> participants) {
        this.attractionName = attractionName;
        this.attractionLocation = attractionLocation;
        this.participants = participants;
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

    public ArrayList<SquadMember> getParticipants() {
        return this.participants;
    }

    public void setParticipants(ArrayList<SquadMember> participants) {
        this.participants = participants;
    }
}
