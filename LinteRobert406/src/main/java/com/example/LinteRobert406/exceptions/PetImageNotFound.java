package com.example.LinteRobert406.exceptions;

public class PetImageNotFound extends RuntimeException{
    public PetImageNotFound(int id) {
        super("Nu exista imagine cu id-ul " + id + "!");
    }
}

