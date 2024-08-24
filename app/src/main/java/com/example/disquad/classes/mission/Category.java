package com.example.disquad.classes.mission;

public class Category {
    // CLASS PROPERTIES
    private String categoryName;
    private int categoryID;



    // CONSTRUCTORS
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }



    // GETTERS / SETTERS
    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return this.categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
