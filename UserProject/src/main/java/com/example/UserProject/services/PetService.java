package com.example.UserProject.services;

import com.example.UserProject.entities.Pet;
import com.example.UserProject.exceptions.PetNotFoundException;
import com.example.UserProject.repositories.PetRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PetService {
    private final static Logger logger = LogManager.getLogger();
    @Autowired
    private PetRepository petRepository;

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet save(Pet pet, int user_id, int centruAdoptieId) {
        pet.setCentruAdoptieId(centruAdoptieId);
        return save(pet);
    }

    public Pet update(Pet pet, int id) {
        Optional<Pet> pet1 = petRepository.findById(id);
        if(pet1.isEmpty()) {
            logger.warn("Could not find pet with id " + id);
            logger.error("Could not update pet");
            throw new PetNotFoundException(id);
        }

        pet1.get().setName(pet.getName());
        pet1.get().setBirthdate(pet.getBirthdate());
        pet1.get().setType(pet.getType());
        pet1.get().setWeight(pet.getWeight());
        pet1.get().setWeightUnit(pet.getWeightUnit());
        return petRepository.save(pet1.get());
    }

    public Pet getById(int id) {
        Optional<Pet> pet = petRepository.findById(id);
        if(pet.isEmpty()) {
            logger.error("Could not find pet with id " + id);
            throw new PetNotFoundException(id);
        }
        return pet.get();
    }

}
