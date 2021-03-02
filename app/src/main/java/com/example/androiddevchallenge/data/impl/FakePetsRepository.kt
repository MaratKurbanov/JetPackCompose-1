package com.example.androiddevchallenge.data.impl

import com.example.androiddevchallenge.data.PetData
import com.example.androiddevchallenge.data.PetRepository
import com.example.androiddevchallenge.model.Dog


class FakePetsRepository : PetRepository {
    override fun getPet(petTag: String): Dog {
        val data = PetData();
        val pets = data.getData();
        val pet = pets.find { it.petTag == petTag }
        return pet!!;
    }

    override fun getPets(): List<Dog> {
        val data = PetData();
        return data.getData();
    }
}