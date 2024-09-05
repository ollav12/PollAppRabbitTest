package com.example.demo.Models;

import java.util.UUID;

public class VoteOption {

    private Integer id;
    private String caption;
    private Integer presentationOrder;

    public VoteOption(String caption, Integer presentationOrder) {
        this.id = Math.abs(UUID.randomUUID().hashCode());
        this.caption = caption;
        this.presentationOrder = presentationOrder;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getPresentationOrder() {
        return presentationOrder;
    }

    public void setPresentationOrder(Integer presentationOrder) {
        this.presentationOrder = presentationOrder;
    }
}
