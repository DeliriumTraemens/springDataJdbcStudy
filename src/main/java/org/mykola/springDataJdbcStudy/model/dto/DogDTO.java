package org.mykola.springDataJdbcStudy.model.dto;

public class DogDTO {
    private Long dogId;
    private String name;
    private String ownerName;

    public Long getDogId() {
        return this.dogId;
    }

    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
