package com.example.LinteRobert406.controllers;

import com.example.LinteRobert406.dtos.PostPetImage;
import com.example.LinteRobert406.dtos.ToReturnPetImage;
import com.example.LinteRobert406.entities.PetImage;
import com.example.LinteRobert406.mappers.PetImageMapper;
import com.example.LinteRobert406.services.PetImageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/petImage")
public class PetImageController {
    private final static Logger logger = LogManager.getLogger();
    @Autowired
    private PetImageService petImageService;
    @Autowired
    private PetImageMapper petImageMapper;

    @PostMapping("/create")
    public ResponseEntity<ToReturnPetImage> save(@RequestBody PostPetImage postPetImage) {
        logger.info("Start create pet image");
        PetImage petImage = petImageService.save(petImageMapper.postPetImageToPetImage(postPetImage), postPetImage.getPetId());

        ToReturnPetImage toReturnPet = petImageMapper.petImageToReturnPetImage(petImage);

        toReturnPet.add(linkTo(methodOn(PetImageController.class).getPetImageById(toReturnPet.getId())).withRel("get pet image by id"));

        toReturnPet.add(linkTo(methodOn(PetImageController.class).getImagesByPetId(toReturnPet.getPetId())).withRel("get pet images by pet id"));

        logger.info("Pet image created successfully");
        return ResponseEntity.created(URI.create("/petImage/"+ toReturnPet.getId()))
                .body(toReturnPet);
    }

    @GetMapping("/{id}")
    public ToReturnPetImage getPetImageById(@PathVariable("id") int id) {
        logger.info("Get pet image with id " + id);
        ToReturnPetImage toReturnPetImage = petImageMapper.petImageToReturnPetImage(petImageService.getById(id));

        toReturnPetImage.add(linkTo(methodOn(PetImageController.class).getImagesByPetId(toReturnPetImage.getPetId())).withRel("get pet images by pet id"));
        return toReturnPetImage;
    }

    @GetMapping("/petId/{id}")
    public List<ToReturnPetImage> getImagesByPetId(@PathVariable("id") int id) {
        logger.info("Get images for pet with id " + id);
        List<ToReturnPetImage> petImages = new ArrayList<>();

        petImageService.getByPetId(id).forEach(
                pet -> {
                    ToReturnPetImage toReturn = petImageMapper.petImageToReturnPetImage(pet);
                    toReturn.add(linkTo(methodOn(PetImageController.class).getPetImageById(toReturn.getId())).withRel("get pet image by id"));
                    petImages.add(toReturn);
                }
        );

        return petImages;
    }
}
