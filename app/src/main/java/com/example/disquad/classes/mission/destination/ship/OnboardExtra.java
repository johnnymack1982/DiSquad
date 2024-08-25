package com.example.disquad.classes.mission.destination.ship;

import android.location.Location;

import com.example.disquad.classes.mission.attraction.Attraction;
import com.example.disquad.classes.squad.SquadMember;

import java.util.ArrayList;
import java.util.Date;

public class OnboardExtra extends Attraction {
    // CLASS PROPERTIES
    private double extraCost;
    private Date reservation;
    private int forwardAft;
    private int starboardPort;



    // CONSTRUCTORS
    public OnboardExtra(String attractionName, Location attractionLocation, ArrayList<SquadMember> participants, double extraCost,
                        Date reservation, int forwardAft, int starboardPort) {
        super(attractionName, attractionLocation, participants);

        this.extraCost = extraCost;
        this.reservation = reservation;
        this.forwardAft = forwardAft;
        this.starboardPort = starboardPort;
    }



    // GETTERS / SETTERS
    public double getExtraCost() {
        return this.extraCost;
    }

    public void setExtraCost(double extraCost) {
        this.extraCost = extraCost;
    }

    public Date getReservation() {
        return this.reservation;
    }

    public void setReservation(Date reservation) {
        this.reservation = reservation;
    }

    public int getForwardAft() {
        return this.forwardAft;
    }

    public void setForwardAft(int forwardAft) {
        this.forwardAft = forwardAft;
    }

    public int getStarboardPort() {
        return this.starboardPort;
    }

    public void setStarboardPort(int starboardPort) {
        this.starboardPort = starboardPort;
    }
}
