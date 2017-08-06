package com.webapplication.dto.residence;

import java.util.Date;

/**
 * Created by panagiotis on 6/8/2017.
 */
public class ReservationDto {

    private Integer userId;
    private Integer residenceId;
    private Date arrivalDate;
    private Date departureDate;

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Integer getResidenceId() {
        return residenceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setResidenceId(Integer residenceId) {
        this.residenceId = residenceId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
