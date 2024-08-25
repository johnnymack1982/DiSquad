package com.example.disquad.classes.mission.destination.park;

import android.location.Location;

import com.example.disquad.classes.mission.destination.Destination;
import com.example.disquad.classes.squad.Squad;
import com.example.disquad.classes.squad.SquadMember;

import java.util.Date;

public class Park extends Destination {
    // CLAS PROPERTIES
    private double dayOfTicketPrice;
    private double dayOfLLPrice;
    private double parkingPrice;
    private double preferredParkingPrice;
    private Date parkOpen;
    private Date parkClose;



    // CONSTRUCTORS
    public Park(int destinationTypeID, String destinationName, Location location, Squad squad, double dayOfTicketPrice, double dayOfLLPrice,
                Date parkOpen, Date parkClose) {
        super(destinationTypeID, destinationName, location, squad);

        this.dayOfTicketPrice = dayOfTicketPrice;
        this.dayOfLLPrice = dayOfLLPrice;
        this.parkOpen = parkOpen;
        this.parkClose = parkClose;

        calculateParking();
    }



    // GETTERS / SETTERS
    public double getDayOfTicketPrice() {
        return this.dayOfTicketPrice;
    }

    public void setDayOfTicketPrice(double dayOfTicketPrice) {
        this.dayOfTicketPrice = dayOfTicketPrice;
    }

    public double getDayOfLLPrice() {
        return this.dayOfLLPrice;
    }

    public void setDayOfLLPrice(double dayOfLLPrice) {
        this.dayOfLLPrice = dayOfLLPrice;
    }

    public double getParkingPrice() {
        return this.parkingPrice;
    }

    public void setParkingPrice(double parkingPrice) {
        this.parkingPrice = parkingPrice;
    }

    public double getPreferredParkingPrice() {
        return this.preferredParkingPrice;
    }

    public void setPreferredParkingPrice(double preferredParkingPrice) {
        this.preferredParkingPrice = preferredParkingPrice;
    }

    public Date getParkOpen() {
        return this.parkOpen;
    }

    public void setParkOpen(Date parkOpen) {
        this.parkOpen = parkOpen;
    }

    public Date getParkClose() {
        return this.parkClose;
    }

    public void setParkClose(Date parkClose) {
        this.parkClose = parkClose;
    }



    // CUSTOM METHODS
    // Custom method to calculate parking prices
    private void calculateParking() {
        SquadMember squadLeader = null;

        for (SquadMember squadMember : this.getSquad().getSquadMembers()) {
            if(squadMember.isSquadLeader()) {
                squadLeader = squadMember;
                break;
            }
        }

        if(squadLeader.isPassHolder()) {
            this.parkingPrice = 0;
            this.preferredParkingPrice = 25;
        }

        else {
            this.parkingPrice = 25;
            this.preferredParkingPrice = 50;
        }
    }
}
