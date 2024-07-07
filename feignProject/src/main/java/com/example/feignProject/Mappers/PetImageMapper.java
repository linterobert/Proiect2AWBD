package com.example.feignProject.Mappers;

import com.example.feignProject.DTOs.PetImageDTOs.PostPetImage;
import com.example.feignProject.DTOs.PetImageDTOs.ToReturnPetImage;
import com.example.feignProject.Domain.PetImage;
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
