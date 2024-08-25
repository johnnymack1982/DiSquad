package com.example.disquad.classes.mission.destination;

import android.location.Location;

import com.example.disquad.classes.mission.attraction.Excursion;
import com.example.disquad.classes.squad.SquadMember;

import java.util.ArrayList;
import java.util.Date;

public class Island extends Destination{
    // CLASS PROPERTIES
    private String islandCountry;
    private Date deboardingTime;
    private Date boardingTime;



    // CONSTRUCTORS
    public Island(int destinationTypeID, String destinationName, Location location, String islandCountry, Date deboardingTime,
                  Date boardingTime, ArrayList<Excursion> excursions) {
        super(destinationTypeID, destinationName, location);

        this.islandCountry = islandCountry;
        this.deboardingTime = deboardingTime;
        this.boardingTime = boardingTime;
    }



    // GETTERS / SETTERS
    public String getIslandCountry() {
        return this.islandCountry;
    }

    public void setIslandCountry(String islandCountry) {
        this.islandCountry = islandCountry;
    }

    public Date getDeboardingTime() {
        return this.deboardingTime;
    }

    public void setDeboardingTime(Date deboardingTime) {
        this.deboardingTime = deboardingTime;
    }

    public Date getBoardingTime() {
        return this.boardingTime;
    }

    public void setBoardingTime(Date boardingTime) {
        this.boardingTime = boardingTime;
    }
}
