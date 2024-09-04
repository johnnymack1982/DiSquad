package com.example.disquad.classes.squad;

import java.io.Serializable;
import java.util.ArrayList;

public class Squad implements Serializable {
    // CLASS PROPERTIES
    private SquadMember squadLeader;
    private ArrayList<SquadMember> squadMembers;
    private ArrayList<ArrayList<PackingItem>> squadPackingList;



    // CONSTRUCTORS
    public Squad(SquadMember squadLeader, ArrayList<SquadMember> squadMembers) {
        this.squadLeader = squadLeader;
        this.squadMembers = squadMembers;
    }



    // GETTERS / SETTERS
    public SquadMember getSquadLeader() {
        return this.squadLeader;
    }

    public void setSquadLeader(SquadMember squadLeader) {
        this.squadLeader = squadLeader;
    }

    public ArrayList<SquadMember> getSquadMembers() {
        return this.squadMembers;
    }

    public void setSquadMembers(ArrayList<SquadMember> squadMembers) {
        this.squadMembers = squadMembers;
    }

    public ArrayList<ArrayList<PackingItem>> getSquadPackingList() {
        return this.squadPackingList;
    }

    public void setSquadPackingList(ArrayList<ArrayList<PackingItem>> squadPackingList) {
        this.squadPackingList = squadPackingList;
    }



    // CUSTOM METHODS
    // Custom method to add a squad member to the squad
    public void addSquadMember(SquadMember squadMember) {
        this.squadMembers.add(squadMember);
    }

    // Custom method to remove a squad member from the squad
    public void removeSquadMember(SquadMember squadMember) {
        this.squadMembers.remove(squadMember);
    }
}
