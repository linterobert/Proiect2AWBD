package com.example.LinteRobert406.mappers;

import com.example.LinteRobert406.dtos.PostPetImage;
import com.example.LinteRobert406.dtos.ToReturnPetImage;
import com.example.LinteRobert406.entities.PetImage;
import org.springframework.stereotype.Component;

@Component
public class PetImageMapper {
    public PetImage postPetImageToPetImage(PostPetImage postPetImage) {
        return new PetImage(postPetImage.getUrl(), postPetImage.getDescription());
    }

    public ToReturnPetImage petImageToReturnPetImage(PetImage petImage) {
        return new ToReturnPetImage(petImage.getId(), petImage.getUrl(), petImage.getDescription(), petImage.getPetId());
    }
}
