package com.example.disquad.classes.mission.budget;

public class Spend {
    // CLASS PROPERTIES
    private String spendName;
    private double cost;
    private BudgetItem budgetItem;
    private int categoryID;



    // CONSTRUCTORS
    public Spend(String spendName, double cost, BudgetItem budgetItem, int categoryID) {
        this.spendName = spendName;
        this.cost = cost;
        this.budgetItem = budgetItem;
        this.categoryID = categoryID;
    }



    // GETTERS = / SETTERS
    public String getSpendName() {
        return this.spendName;
    }

    public void setSpendName(String spendName) {
        this.spendName = spendName;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public BudgetItem getBudgetItem() {
        return this.budgetItem;
    }

    public void setBudgetItem(BudgetItem budgetItem) {
        this.budgetItem = budgetItem;
    }

    public int getCategoryID() {
        return this.categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
