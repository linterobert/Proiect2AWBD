package com.example.UserProject.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class PostPet {
    @Length(min = 5, max = 55)
    private String name;
    @NotNull
    private int petType;
    @Min(0)
    private double weight;
    @NotNull
    private int weightUnitType;
    @Past(message = "Data nu trebuie să fie în viitor")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthdate;
    @NotNull
    private int centru_adoptie_id;
    @NotNull
    private int user_id;


    public PostPet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPetType() {
        return petType;
    }

    public void setPetType(int petType) {
        this.petType = petType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getWeightUnitType() {
        return weightUnitType;
    }

    public void setWeightUnitType(int weightUnitType) {
        this.weightUnitType = weightUnitType;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getCentru_adoptie_id() {
        return centru_adoptie_id;
    }

    public void setCentru_adoptie_id(int centru_adoptie_id) {
        this.centru_adoptie_id = centru_adoptie_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
