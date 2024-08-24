package com.example.disquad.classes.mission;

import com.example.disquad.classes.mission.budget.Budget;
import com.example.disquad.classes.mission.destination.Destination;
import com.example.disquad.classes.squad.Squad;

import java.util.ArrayList;
import java.util.Date;

public class Mission {
    // CLASS PROPERTIES
    private Squad squad;
    private Date startDate;
    private Date endDate;
    ArrayList<Destination> destinations;
    Budget budget;
    ArrayList<Stay> stays;



    // CONSTRUCTORS
    public Mission(Squad squad, Date startDate, Date endDate, ArrayList<Destination> destinations, ArrayList<Stay> stays) {
        this.squad = squad;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destinations = destinations;
        this.stays = stays;
    }



    // GETTERS / SETTERS
    public Squad getSquad() {
        return this.squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
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

    public ArrayList<Destination> getDestinations() {
        return this.destinations;
    }

    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations;
    }

    public Budget getBudget() {
        return this.budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public ArrayList<Stay> getStays() {
        return this.stays;
    }

    public void setStays(ArrayList<Stay> stays) {
        this.stays = stays;
    }



    // CUSTOM METHODS
    // Custom method to add to list of destinations
    public void addDestination(Destination destination) {
        this.destinations.add(destination);
    }

    // Custom method to remove from list of destinations
    public void removeDestination(Destination destination) {
        this.destinations.remove(destination);
    }

    // Custom method to add to list of stays
    public void addStay(Stay stay) {
        this.stays.add(stay);
    }

    // Custom method to remove from list of stays
    public void removeStay(Stay stay) {
        this.stays.remove(stay);
    }
}
