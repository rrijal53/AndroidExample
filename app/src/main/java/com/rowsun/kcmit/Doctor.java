package com.rowsun.kcmit;

/**
 * Created by rowsun on 8/1/17.
 */

public class Doctor {
    private String id, name, hospital, description, gender;

    public Doctor() {
    }

    public Doctor(String id, String name, String hospital, String description, String gender) {
        this.id = id;
        this.name = name;
        this.hospital = hospital;
        this.description = description;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public Doctor setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Doctor setName(String name) {
        this.name = name;
        return this;
    }

    public String getHospital() {
        return hospital;
    }

    public Doctor setHospital(String hospital) {
        this.hospital = hospital;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Doctor setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Doctor setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
