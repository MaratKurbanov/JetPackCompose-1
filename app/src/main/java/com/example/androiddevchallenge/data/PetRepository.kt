package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.model.Dog

interface PetRepository {
    /**
     * Get a specific pet info.
     */
    fun getPet(petTag: String): Dog

    /**
     * Get all pets.
     */
    fun getPets(): List<Dog>
}