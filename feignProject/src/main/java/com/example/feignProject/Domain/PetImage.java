package com.example.feignProject.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PetImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;

    private String description;

    private int petId;

    public PetImage(int id, String url, String description) {
        this.id = id;
        this.url = url;
        this.description = description;
    }

    public PetImage(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public PetImage() {
    }
}
