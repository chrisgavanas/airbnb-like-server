package com.webapplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by panagiotis on 6/8/2017.
 */
@Embeddable
public class ReservationEntityPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JsonBackReference
    private UserEntity user;
    @ManyToOne
    @JsonBackReference
    private ResidenceEntity residence;


    public ResidenceEntity getResidence() {
        return residence;
    }

    public void setResidence(ResidenceEntity residence) {
        this.residence = residence;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntityPK that = (ReservationEntityPK) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (residence != null ? !residence.equals(that.residence) : that.residence != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (user != null ? user.hashCode() : 0);
        result = 31 * result + (residence != null ? residence.hashCode() : 0);
        return result;
    }
}
