package com.example.mydoctor.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "diseases")
public class Diseases {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String symptoms;
    String precautions;

    public Diseases() {
    }

    public Diseases(String name, String symptoms, String precautions) {
        this.name = name;
        this.symptoms = symptoms;
        this.precautions = precautions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }
}
