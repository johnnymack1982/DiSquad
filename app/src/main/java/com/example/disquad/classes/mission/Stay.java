package com.example.disquad.classes.mission;

import android.location.Location;

import java.util.Date;

public class Stay {
    // CLASS PROPERTIES
    private int stayTypeID;
    private String stayName;
    private Location stayLocation;
    private Date startDate;
    private Date endDate;



    // CONSTRUCTORS
    public Stay(int stayTypeID, String stayName, Location stayLocation, Date startDate, Date endDate) {
        this.stayTypeID = stayTypeID;
        this.stayName = stayName;
        this.stayLocation = stayLocation;
        this.startDate = startDate;
        this.endDate = endDate;
    }



    // GETTERS / SETTERS
    public int getStayTypeID() {
        return this.stayTypeID;
    }

    public void setStayTypeID(int stayTypeID) {
        this.stayTypeID = stayTypeID;
    }

    public String getStayName() {
        return this.stayName;
    }

    public void setStayName(String stayName) {
        this.stayName = stayName;
    }

    public Location getStayLocation() {
        return this.stayLocation;
    }

    public void setStayLocation(Location stayLocation) {
        this.stayLocation = stayLocation;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
