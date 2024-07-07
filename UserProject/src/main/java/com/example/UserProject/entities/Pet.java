package com.example.UserProject.entities;

import com.example.UserProject.enums.PetType;
import com.example.UserProject.enums.WeightType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private PetType type;

    private double weight;

    @Enumerated(EnumType.ORDINAL)
    private WeightType weightUnit;

    private Date birthdate;

    private int centruAdoptieId;

    public Pet(int id, String name, PetType type, double weight, WeightType weightUnit, Date birthdate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.birthdate = birthdate;
    }

    public Pet(String name, PetType type, double weight, WeightType weightUnit, Date birthdate) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.birthdate = birthdate;
    }

    public Pet() {

    }
}
