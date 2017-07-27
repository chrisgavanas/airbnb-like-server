package com.webapplication.dto.residence;

/**
 * Created by panagiotis on 27/7/2017.
 */
public class SearchResidenceDto {

    private String location;

    private String datesAvailable;

    private Integer capacity;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDatesAvailable() {
        return datesAvailable;
    }

    public void setDatesAvailable(String datesAvailable) {
        this.datesAvailable = datesAvailable;
    }

}
