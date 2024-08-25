package com.example.disquad.classes.mission.destination.ship;

public class StateRoom {
    // CLASS PROPERTIES
    private String roomNumber;
    private int deck;
    private int forwardAft;
    private int starboardPort;
    private String category;



    // CONSTRUCTORS
    public StateRoom(String roomNumber, int deck, int forwardAft, int starboardPort, String category) {
        this.roomNumber = roomNumber;
        this.deck = deck;
        this.forwardAft = forwardAft;
        this.starboardPort = starboardPort;
        this.category = category;
    }



    // GETTERS / SETTERS
    public String getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getDeck() {
        return this.deck;
    }

    public void setDeck(int deck) {
        this.deck = deck;
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

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
