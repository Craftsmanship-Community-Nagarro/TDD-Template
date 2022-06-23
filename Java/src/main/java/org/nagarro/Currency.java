package org.nagarro;

public enum Currency {
    USD("US Dollar"),
    EUR("EURO"),
    KRW("Korean Won");

    private final String description;

    private Currency(final String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
