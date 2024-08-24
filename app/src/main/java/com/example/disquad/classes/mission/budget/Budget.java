package com.example.disquad.classes.mission.budget;

import java.util.ArrayList;

public class Budget {
    // CLASS PROPERTIES
    private ArrayList<BudgetItem> budgetItems;
    private double startingTotalBudget;
    private double currentTotalBudget;



    // CONSTRUCTORS
    public Budget(ArrayList<BudgetItem> budgetItems) {
        this.budgetItems = budgetItems;
    }



    // GETTERS / SETTERS
    public ArrayList<BudgetItem> getBudgetItems() {
        return this.budgetItems;
    }

    public void setBudgetItems(ArrayList<BudgetItem> budgetItems) {
        this.budgetItems = budgetItems;
    }

    public double getStartingTotalBudget() {
        return this.startingTotalBudget;
    }

    public void setStartingTotalBudget(double startingTotalBudget) {
        this.startingTotalBudget = startingTotalBudget;
    }

    public double getCurrentTotalBudget() {
        return this.currentTotalBudget;
    }

    public void setCurrentTotalBudget(double currentTotalBudget) {
        this.currentTotalBudget = currentTotalBudget;
    }



    // CUSTOM METHODS
    // Custom method to update total starting budget
    public void updateStartingTotalBudget() {
        // Reset total starting budget to zero
        this.startingTotalBudget = 0;

        for (BudgetItem budgetItem : budgetItems) {
            this.startingTotalBudget = this.startingTotalBudget + budgetItem.getItemStartingBudget();
        }
    }

    // Custom method to update total current budget
    public void updateCurrentTotalBudget() {
        // Reset total current budget to zero
        this.startingTotalBudget = 0;

        for (BudgetItem budgetItem : budgetItems) {
            this.currentTotalBudget = this.currentTotalBudget + budgetItem.getItemCurrentBudget();
        }
    }
}
