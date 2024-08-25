package com.example.disquad.classes.mission.destination.park;

import android.location.Location;

import com.example.disquad.classes.mission.attraction.Attraction;
import com.example.disquad.classes.squad.SquadMember;

import java.util.ArrayList;

public class ParkAttraction extends Attraction {
    // CLASS PROPERTIES
    private double iLLCost;
    private int standbyTime;



    // CONSTRUCTORS
    public ParkAttraction(String attractionName, Location attractionLocation, ArrayList<SquadMember> participants, double iLLCost,
                          int standbyTime) {
        super(attractionName, attractionLocation, participants);

        this.iLLCost = iLLCost;
        this.standbyTime = standbyTime;
    }



    // GETTERS / SETTERS
    public double getiLLCost() {
        return this.iLLCost;
    }

    public void setiLLCost(double iLLCost) {
        this.iLLCost = iLLCost;
    }

    public int getStandbyTime() {
        return this.standbyTime;
    }

    public void setStandbyTime(int standbyTime) {
        this.standbyTime = standbyTime;
    }
}
