package com.example.UserProject.repositories;

import com.example.UserProject.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>, PagingAndSortingRepository<Pet, Integer>, CrudRepository<Pet, Integer>
{
    Optional<Pet> findById(int id);

    @Query("SELECT p FROM Pet p")
    List<Pet> getAll(Pageable p);
}
