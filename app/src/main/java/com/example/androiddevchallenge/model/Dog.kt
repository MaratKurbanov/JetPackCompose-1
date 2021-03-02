package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

data class Dog(
    val petTag: String,
    val name: String,
    val age: DogAge,
    val breed: Breed,
    val gender: Gender,
    val color: String,
    val weight: Double,
    val location: String,
    val details: String,
    @DrawableRes val imageId: Int,
    val adoptLink: String,
)

enum class Gender() {
    Male,
    Female,
}

enum class DogAge(val color: String) {
    Puppy("puppy"),
    Young("young"),
    Adult("adult"),
    Senior("senior")
}

enum class Breed(val color: String) {
    Retriever("Retriever - Labrador"),
    GermanShepherd("German Shepherd"),
    FrenchBulldog("French Bulldog"),
    Bulldog("Bulldog"),
    Poodle("Poodle"),
    Beagle("Beagle"),
    Rottweiler("Rottweiler")
}
