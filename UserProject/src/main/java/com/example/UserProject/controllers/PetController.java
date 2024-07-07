package com.example.UserProject.controllers;

import com.example.UserProject.dtos.PostPet;
import com.example.UserProject.dtos.PutPet;
import com.example.UserProject.dtos.ToReturnPet;
import com.example.UserProject.entities.Pet;
import com.example.UserProject.mappers.PetMapper;
import com.example.UserProject.services.PetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    private final static Logger logger = LogManager.getLogger();
    @Autowired
    private PetService petService;
    @Autowired
    private PetMapper petMapper;

    @PostMapping("/create")
    public ResponseEntity<ToReturnPet> save(@RequestBody PostPet postPet) {
        logger.info("Start create pet");
        Pet pet = petService.save(petMapper.postPetToPet(postPet), postPet.getUser_id(), postPet.getCentru_adoptie_id());

        ToReturnPet toReturnPet = petMapper.petToReturnPet(pet);

        logger.info("Pet created successfully");
        return ResponseEntity.created(URI.create("/pet/"+ toReturnPet.getId()))
                .body(toReturnPet);
    }

    @GetMapping("/{id}")
    public ToReturnPet getPetById(@PathVariable("id") int id) {
        logger.info("Get pet with id " + id);
        return petMapper.petToReturnPet(petService.getById(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<ToReturnPet> updatePet(@PathVariable("id") int id, @RequestBody PutPet putPet) {
        logger.info("Start update pet with id " + id);
        Pet pet = petMapper.putPetToPet(putPet);
        pet.setId(id);
        return ResponseEntity.ok(petMapper.petToReturnPet(petService.update(pet, id)));
    }
}
