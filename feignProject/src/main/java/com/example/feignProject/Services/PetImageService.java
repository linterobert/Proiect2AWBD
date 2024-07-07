package com.example.feignProject.Services;

import com.example.feignProject.Domain.PetImage;
import com.example.feignProject.Exceptions.PetImageNotFound;
import com.example.feignProject.Interfaces.PetImageRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class PetImageService {
    private final static Logger logger = LogManager.getLogger();
    @Autowired
    private PetImageRepository petImageRepository;

    public PetImage save(PetImage petImage) {
        return petImageRepository.save(petImage);
    }

    public PetImage save(PetImage petImage, int petId) {
        //Optional<Pet> pet = petRepository.findById(petId);

        //request catre alt service care ne zice daca exista sau nu pet ul
        /*if(pet.isEmpty()) {
            logger.warn("Could not find pet with id " + petId);
            logger.error("Could not create Pet Image");
            throw new PetNotFoundException(petId);
        }*/

        petImage.setPetId(petId);
        return save(petImage);
    }

    public PetImage getById(int id) {
        Optional<PetImage> petImage = petImageRepository.findById(id);
        if(petImage.isEmpty()) {
            logger.error("Could not find pet image with id " + id);
            throw new PetImageNotFound(id);
        }
        return petImage.get();
    }

    public List<PetImage> getByPetId(int id) {
        return petImageRepository.getPetImagesByPetId(id);
    }
}
