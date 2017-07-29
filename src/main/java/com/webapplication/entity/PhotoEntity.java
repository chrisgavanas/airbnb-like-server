package com.webapplication.entity;

import javax.persistence.*;

@Entity(name = "Photos")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PHOTO_ID")
    private Integer photoId;

    @Column(name = "PATH")
    private String path;

    @ManyToOne
    @JoinColumn(name = "Residences_RESIDENCE_ID")
    private ResidenceEntity residenceEntity;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ResidenceEntity getResidenceEntity() {
        return residenceEntity;
    }

    public void setResidenceEntity(ResidenceEntity residenceEntity) {
        this.residenceEntity = residenceEntity;
    }
}