package com.example.disquad.classes.mission.destination.park;

import android.location.Location;

import com.example.disquad.classes.squad.SquadMember;

import java.util.ArrayList;
import java.util.Date;

public class Show extends ParkAttraction{
    // CLASS PROPERTIES
    private ArrayList<Date> showtimes;
    private Date nextShowtimes;



    // CONSTRUCTORS
    public Show(String attractionName, Location attractionLocation, ArrayList<SquadMember> participants, double iLLCost, int standbyTime,
                ArrayList<Date> showtimes) {
        super(attractionName, attractionLocation, participants, iLLCost, standbyTime);

        this.showtimes = showtimes;
    }



    // GETTERS / SETTERS
    public ArrayList<Date> getShowtimes() {
        return this.showtimes;
    }

    public void setShowtimes(ArrayList<Date> showtimes) {
        this.showtimes = showtimes;
    }

    public Date getNextShowtimes() {
        // TODO: CALCULATE NEXT SHOW TIME BASED ON CURRENT TIME AND DATE
        return nextShowtimes;
    }

    public void setNextShowtimes(Date nextShowtimes) {
        this.nextShowtimes = nextShowtimes;
    }
}
