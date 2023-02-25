package com.company;

import java.util.ArrayList;

public class PublishingRetailer {
    private int ID;
    private String name;
    private ArrayList<IPublishingArtifact> publishingArtifacts;
    private ArrayList<Countries> countries;

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<IPublishingArtifact> getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public ArrayList<Countries> getCountries() {
        return countries;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishingArtifacts(ArrayList<IPublishingArtifact> publishingArtifacts) {
        this.publishingArtifacts = publishingArtifacts;
    }

    public void setCountries(ArrayList<Countries> countries) {
        this.countries = countries;
    }
}
