package com.webapplication.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by panagiotis on 6/8/2017.
 */
@Entity
@Table(name="Reservations")
@AssociationOverrides({
        @AssociationOverride(name = "pk.user",
                joinColumns = @JoinColumn(name = "USERNAME")),
        @AssociationOverride(name = "pk.residence",
                joinColumns = @JoinColumn(name = "RESIDENCE_ID")) })
public class ReservationEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ReservationEntityPK pk = new ReservationEntityPK();

    @Column(name = "ARRIVAL_DATE")
    private Date arrivalDate;
    @Column(name = "DEPARTURE_DATE")
    private Date departureDate;


    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public ReservationEntityPK getPk() {
        return pk;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setPk(ReservationEntityPK pk) {
        this.pk = pk;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}
