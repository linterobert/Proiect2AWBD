package com.example.feignProject.Exceptions;

public class PetImageNotFound extends RuntimeException{
    public PetImageNotFound(int id) {
        super("Nu exista imagine cu id-ul " + id + "!");
    }
}
