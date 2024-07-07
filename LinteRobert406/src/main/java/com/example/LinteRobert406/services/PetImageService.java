package com.example.LinteRobert406.services;

import com.example.LinteRobert406.entities.PetImage;
import com.example.LinteRobert406.exceptions.PetImageNotFound;
import com.example.LinteRobert406.repositories.PetImageRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PetImageService {
    private final static Logger logger = LogManager.getLogger();
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PetImageRepository petImageRepository;

    public PetImage save(PetImage petImage) {
        return petImageRepository.save(petImage);
    }

    @CircuitBreaker(name = "pet", fallbackMethod = "fallbackGetPet")
    @Retry(name = "pet")
    public PetImage save(PetImage petImage, int petId) {
        String url = "http://user-service/pet/" + petId;
        String response = restTemplate.getForObject(url, String.class);
        petImage.setPetId(petId);
        return petImageRepository.save(petImage);
    }

    // Fallback method for CircuitBreaker and Retry annotations
    public String fallbackGetPet(Throwable throwable) {
        // Handle fallback logic here
        logger.error("Fallback method triggered for getPet", throwable);
        return "Fallback response: Unable to get pet";
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
