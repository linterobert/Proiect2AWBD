package com.example.feignProject.Controllers;

import com.example.feignProject.DTOs.PetImageDTOs.PostPetImage;
import com.example.feignProject.DTOs.PetImageDTOs.ToReturnPetImage;
import com.example.feignProject.Domain.PetImage;
import com.example.feignProject.Interfaces.PetImageFeign;
import com.example.feignProject.Mappers.PetImageMapper;
import com.example.feignProject.Services.PetImageService;
import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/petImage")
public class PetImageController {
    private final static Logger logger = LogManager.getLogger();
    @Autowired
    private PetImageService petImageService;
    @Autowired
    private PetImageMapper petImageMapper;
    @Autowired
    private PetImageFeign petImageFeign;

    @PostMapping("/create")
    public ResponseEntity<ToReturnPetImage> save(@RequestBody PostPetImage postPetImage) {
        logger.info("Start create pet image");
        PetImage petImage = petImageService.save(petImageMapper.postPetImageToPetImage(postPetImage), postPetImage.getPetId());

        ToReturnPetImage toReturnPet = petImageMapper.petImageToReturnPetImage(petImage);

        logger.info("Pet image created successfully");
        return ResponseEntity.created(URI.create("/petImage/"+ toReturnPet.getId()))
                .body(toReturnPet);
    }

    /*@GetMapping("/{id}")
    public ToReturnPetImage getPetImageById(@PathVariable("id") int id) {
        logger.info("Get pet image with id " + id);
        return petImageMapper.petImageToReturnPetImage(petImageService.getById(id));
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<PetImage> getPetImageById(@PathVariable("id") int id) {
        logger.info("Get pet image with id " + id);
        return petImageFeign.getPetImageById(id);
    }

    @GetMapping("/petId/{id}")
    public List<ToReturnPetImage> getImagesByPetId(@PathVariable("id") int id) {
        logger.info("Get images for pet with id " + id);
        List<ToReturnPetImage> petImages = new ArrayList<>();

        petImageService.getByPetId(id).forEach(pet -> petImages.add(petImageMapper.petImageToReturnPetImage(pet)));

        return petImages;
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id) {
        logger.info("Delete image with id " + id);
        petImageFeign.deletePetImageById(id);
        return ResponseEntity.noContent().build();
    }
}
