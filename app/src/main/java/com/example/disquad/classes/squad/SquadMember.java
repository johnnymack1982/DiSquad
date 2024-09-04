package com.example.disquad.classes.squad;

import android.location.Location;

import com.example.disquad.classes.mission.attraction.Attraction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SquadMember implements Serializable {
    // CLASS PROPERTIES
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String mobileNumber;
    private Date dateOfBirth;
    private int age;
    private int height;
    private ArrayList<PackingItem> packingList;
    private Location location;
    private boolean isSquadLeader;
    private boolean passHolder;
    private boolean hasDAS;
    private boolean llMultiPass;
    private ArrayList<Attraction> individualLLPasses;



    // CONSTRUCTORS
    public SquadMember(String firstName, String lastName, String emailAddress, String mobileNumber, Date dateOfBirth, int height, boolean isSquadLeader,
                       boolean passHolder, boolean hasDAS) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        this.age = calculateAge();
        this.height = height;
        this.isSquadLeader = isSquadLeader;
        this.passHolder = passHolder;
        this.hasDAS = hasDAS;
    }



    // GETTERS / SETTERS
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<PackingItem> getPackingList() {
        return this.packingList;
    }

    public void setPackingList(ArrayList<PackingItem> packingList) {
        this.packingList = packingList;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isSquadLeader() {
        return this.isSquadLeader;
    }

    public void setSquadLeader(boolean squadLeader) {
        this.isSquadLeader = squadLeader;
    }

    public boolean isPassHolder() {
        return this.passHolder;
    }

    public void setPassHolder(boolean passHolder) {
        this.passHolder = passHolder;
    }

    public boolean isLlMultiPass() {
        return this.llMultiPass;
    }

    public void setLlMultiPass(boolean llMultiPass) {
        this.llMultiPass = llMultiPass;
    }

    public ArrayList<Attraction> getIndividualLLPasses() {
        return this.individualLLPasses;
    }

    public void setIndividualLLPasses(ArrayList<Attraction> individualLLPasses) {
        this.individualLLPasses = individualLLPasses;
    }

    public boolean isHasDAS() {
        return hasDAS;
    }

    public void setHasDAS(boolean hasDAS) {
        this.hasDAS = hasDAS;
    }



    // CUSTOM METHODS
    // Custom method to calculate quad member's age
    private int calculateAge() {
        // Calculate current year
        Date currentDate = Calendar.getInstance().getTime();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(currentDate);
        int currentYear = calendar.get(Calendar.YEAR);

        // Calculate current month
        int currentMonth = calendar.get(Calendar.MONTH);

        // Calculate current day
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        // Calculate year of birth
        calendar.setTime(this.dateOfBirth);
        int yearOfBirth = calendar.get(Calendar.YEAR);

        // Calculate month of birth
        int monthOfBirth = calendar.get(Calendar.MONTH);

        // Calculate day of birth
        int dayOfBirth = calendar.get(Calendar.DAY_OF_MONTH);

        // Calculate age
        int age = currentYear - yearOfBirth;

        if(monthOfBirth > currentMonth && dayOfBirth > currentDay) {
            age--;
        }

        return age;
    }

    // Custom method to add an item to the squad member's packing list
    public void addToPackingList(PackingItem packingItem) {
        this.packingList.add(packingItem);
    }

    // Custom method to remove an item from the squad member's packing list
    public void removeFromPackingList(PackingItem packingItem) {
        this.packingList.remove(packingItem);
    }

    // Custom method to add ILL pass to squad member
    public void addIndividualLLPass(Attraction attraction) {
        this.individualLLPasses.add(attraction);
    }

    // Custom method to remove ILL pass from squad member
    public void removeIndividualLLPass(Attraction attraction) {
        this.individualLLPasses.remove(attraction);
    }
}
