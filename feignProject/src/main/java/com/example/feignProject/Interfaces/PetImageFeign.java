package com.example.feignProject.Interfaces;

import com.example.feignProject.Domain.PetImage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="petImage")
public interface PetImageFeign {
    @RequestMapping(method = RequestMethod.GET,
            value = "/petImage/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<PetImage> getPetImageById(@PathVariable("id") int id);


    @RequestMapping(method = RequestMethod.DELETE,
            value = "/petImage/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity deletePetImageById(@PathVariable("id") int id);
}
