package com.example.demo;

public class Suggestion {

    private String gadget;
    private int hoursGuaranteed;

    public Suggestion(int hoursGuaranteed, String gadget) {
        this.hoursGuaranteed = hoursGuaranteed;
        this.gadget = gadget;
    }

    public Suggestion() {}

    public String getGadget() {
        return gadget;
    }

    public void setGadget(String gadget) {
        this.gadget = gadget;
    }

    public int getHoursGuaranteed() {
        return hoursGuaranteed;
    }

    public void setHoursGuaranteed(int hoursGuaranteed) {
        this.hoursGuaranteed = hoursGuaranteed;
    }
}
