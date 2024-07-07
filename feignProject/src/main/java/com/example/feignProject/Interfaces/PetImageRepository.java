package com.example.feignProject.Interfaces;

import com.example.feignProject.Domain.PetImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface PetImageRepository extends JpaRepository<PetImage, Integer>, PagingAndSortingRepository<PetImage, Integer> {
    List<PetImage> getPetImagesByPetId(int petId);
}
