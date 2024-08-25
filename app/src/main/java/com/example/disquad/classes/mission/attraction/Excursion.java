package com.example.disquad.classes.mission.attraction;

import android.location.Location;

import com.example.disquad.classes.squad.SquadMember;

import java.util.ArrayList;
import java.util.Date;

public class Excursion extends Attraction {
    // CLASS PROPERTIES
    private Date startTime;
    private Date endTime;
    private double excersionCost;




    // CONSTRUCTORS
    public Excursion(String attractionName, Location attractionLocation, ArrayList<SquadMember> participants, Date startTime,
                     Date endTime, double excersionCost) {
        super(attractionName, attractionLocation, participants);

        this.startTime = startTime;
        this.endTime = endTime;
        this.excersionCost = excersionCost;
    }



    // GETTERS / SETTERS
    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getExcersionCost() {
        return this.excersionCost;
    }

    public void setExcersionCost(double excersionCost) {
        this.excersionCost = excersionCost;
    }
}
