package com.example.disquad.classes.mission.destination.park;

import android.location.Location;

import com.example.disquad.classes.squad.SquadMember;

import java.util.ArrayList;

public class Ride extends ParkAttraction{
    // CLASS PROPERTIES
    private int heightRequirement;
    private int intensity;



    // CONSTRUCTORS
    public Ride(String attractionName, Location attractionLocation, ArrayList<SquadMember> participants, double iLLCost, int standbyTime,
                int heightRequirement, int intensity) {
        super(attractionName, attractionLocation, participants, iLLCost, standbyTime);

        this.heightRequirement = heightRequirement;
        this.intensity = intensity;
    }



    // GETTERS / SETTERS
    public int getHeightRequirement() {
        return this.heightRequirement;
    }

    public void setHeightRequirement(int heightRequirement) {
        this.heightRequirement = heightRequirement;
    }

    public int getIntensity() {
        return this.intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
