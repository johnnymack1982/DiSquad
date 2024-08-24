package com.example.disquad.classes.mission.budget;

public class BudgetItem {
    // CLASS PROPERTIES
    private String itemName;
    private double itemStartingBudget;
    private double itemCurrentBudget;



    // CONSTRUCTORS
    public BudgetItem(String itemName, double itemStartingBudget) {
        this.itemName = itemName;
        this.itemStartingBudget = itemStartingBudget;
        this.itemCurrentBudget = itemStartingBudget;
    }



    // GETTERS / SETTERS
    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemStartingBudget() {
        return this.itemStartingBudget;
    }

    public void setItemStartingBudget(double itemStartingBudget) {
        this.itemStartingBudget = itemStartingBudget;
    }

    public double getItemCurrentBudget() {
        return this.itemCurrentBudget;
    }

    public void setItemCurrentBudget(double itemCurrentBudget) {
        this.itemCurrentBudget = itemCurrentBudget;
    }



    // CUSTOM METHODS
    // Custom method to decrease current budget
    public void recordSpending(double amountSpent) {
        this.itemCurrentBudget = this.itemCurrentBudget - amountSpent;
    }
}
