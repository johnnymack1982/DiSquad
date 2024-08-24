package com.example.disquad.classes.squad;

public class PackingItem {
    // CLASS PROPERTIES
    private String itemName;
    private int quantity;
    private boolean packed;



    // CONSTRUCTORS
    public PackingItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.packed = false;
    }



    // GETTERS / SETTERS
    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isPacked() {
        return this.packed;
    }

    public void setPacked(boolean packed) {
        this.packed = packed;
    }
}
