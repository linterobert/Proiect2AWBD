package com.example.UserProject.mappers;

import com.example.UserProject.dtos.PostPet;
import com.example.UserProject.dtos.PutPet;
import com.example.UserProject.dtos.ToReturnPet;
import com.example.UserProject.entities.Pet;
import com.example.UserProject.enums.PetType;
import com.example.UserProject.enums.WeightType;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {
    public Pet postPetToPet(PostPet postPet) {
        return new Pet(postPet.getName(), PetType.fromId(postPet.getPetType()), postPet.getWeight(), WeightType.fromId(postPet.getWeightUnitType()), postPet.getBirthdate());
    }

    public ToReturnPet petToReturnPet(Pet pet) {
        return new ToReturnPet(pet.getId(), pet.getName(), pet.getType(), pet.getWeight(), pet.getWeightUnit(), pet.getBirthdate(), pet.getCentruAdoptieId());
    }

    public Pet putPetToPet(PutPet putPet) {
        return new Pet(putPet.getName(), PetType.fromId(putPet.getPetType()), putPet.getWeight(), WeightType.fromId(putPet.getWeightUnitType()), putPet.getBirthdate());
    }
}
