package com.example.LinteRobert406.dtos;

import com.example.LinteRobert406.entities.PetImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@AllArgsConstructor
public class ToReturnPetImage extends RepresentationModel<ToReturnPetImage> {
    private int id;
    private String url;
    private String description;
    private int petId;
}
