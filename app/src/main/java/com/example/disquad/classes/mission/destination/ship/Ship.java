package com.example.disquad.classes.mission.destination.ship;

import android.location.Location;

import com.example.disquad.classes.mission.destination.Destination;
import com.example.disquad.classes.mission.destination.Island;
import com.example.disquad.classes.squad.Squad;

import java.util.ArrayList;
import java.util.Date;

public class Ship extends Destination {
    //CLASS PROPERTIES
    private int portID;
    private Location portAddress;
    private ArrayList<StateRoom> stateRooms;
    private double cruisePrice;
    private ArrayList<Island> islands;
    private Date diningTime;



    // CONSTRUCTORS
    public Ship(int destinationTypeID, String destinationName, Location location, Squad squad, int portID, Location portAddress,
                ArrayList<StateRoom> stateRooms, double cruisePrice, ArrayList<Island> islands, Date diningTime) {
        super(destinationTypeID, destinationName, location, squad);

        this.portID = portID;
        this.portAddress = portAddress;
        this.stateRooms = stateRooms;
        this.cruisePrice = cruisePrice;
        this.islands = islands;
        this.diningTime = diningTime;
    }



    // GETTERS / SETTERS
    public int getPortID() {
        return this.portID;
    }

    public void setPortID(int portID) {
        this.portID = portID;
    }

    public Location getPortAddress() {
        return this.portAddress;
    }

    public void setPortAddress(Location portAddress) {
        this.portAddress = portAddress;
    }

    public ArrayList<StateRoom> getStateRooms() {
        return this.stateRooms;
    }

    public void setStateRooms(ArrayList<StateRoom> stateRooms) {
        this.stateRooms = stateRooms;
    }

    public double getCruisePrice() {
        return this.cruisePrice;
    }

    public void setCruisePrice(double cruisePrice) {
        this.cruisePrice = cruisePrice;
    }

    public ArrayList<Island> getIslands() {
        return this.islands;
    }

    public void setIslands(ArrayList<Island> islands) {
        this.islands = islands;
    }

    public Date getDiningTime() {
        return this.diningTime;
    }

    public void setDiningTime(Date diningTime) {
        this.diningTime = diningTime;
    }
}
