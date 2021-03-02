package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Breed
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.model.DogAge
import com.example.androiddevchallenge.model.Gender

class PetData {
    fun getData(): List<Dog> {
        val d = Dog(
            "1a",
            "Frannie",
            DogAge.Young,
            Breed.GermanShepherd,
            Gender.Female,
            "Dark Brown",
            53.0,
            "Columbia City, IN",
            "Medical History: At the previous shelter, they noted she may have had a seizure. " +
                "They did full bloodwork diagnostics and all values were normal. " +
                "No issues since that day which was 1/25/21. She appears to be a very healthy girl." +
                " We want to inform you just in case she may need anti-seizure medication later in " +
                "life if she has any other episodes, but has only had the one case.\n" +
                "She would likely do fine with older kids\n" +
                "She absolutely loves toys, and squeaker toys and the gaggle ball are her favorites!\n" +
                "She is extremely intelligent, and knows SIT, SHAKE, LIE DOWN, and is " +
                "learning more things day by day!",
            imageId = R.drawable.german_sheperd,
            adoptLink = "https://www.adoptapet.com/pet/30641168-columbia-city-indiana-german-shepherd-dog"
        )
        val d2 = Dog(
            "2a",
            "Rumor",
            DogAge.Puppy,
            Breed.Retriever,
            Gender.Female,
            "Black",
            20.0,
            "Waterloo, IN",
            "Rumor was 2 years old at the end of November. She is being owner surrendered " +
                "due to a family health emergency, and they can no longer care for her. " +
                "Rumor is spayed, up to date on shots, microchipped, and heartworm negative " +
                "and on prevention. She loves to spend time outside and play. " +
                "She must have a secure fenced-in yard. Rumor is good with kids and dogs her " +
                "size and larger. She does not realize her size and plays too rough to be in a " +
                "home with smaller dogs. She also has not been around cats since she was a puppy " +
                "but most likely would also play too rough, so a home with no cats would be best. " +
                "This girl is very loving and cuddly. She enjoys spending time curled up next " +
                "to you while you watch TV or read a book.",
            imageId = R.drawable.labrador,
            adoptLink = "https://www.adoptapet.com/pet/29677161-waterloo-indiana-labrador-retriever"
        )
        val d3 = Dog(
            "3a",
            "Rambo",
            DogAge.Senior,
            Breed.Poodle,
            Gender.Male,
            "Dark Grey",
            75.0,
            "Columbia City, IN",
            "Intake: Transfer from another shelter\n" +
                "I would be fine with bigger kids so that I don't knock them down\n" +
                "I absolutely LOVE to be pet and snuggled\n" +
                "I like playing with toys and have quite a bit of energy for being a distinguished older gentleman\n" +
                "I know how to SIT, SHAKE, and LIE DOWN\n" +
                "I love going for walks on leash, but I do tend to pull",
            imageId = R.drawable.poodle,
            adoptLink = "https://www.adoptapet.com/pet/30611283-columbia-city-indiana-standard-poodle"
        )
        val d4 = Dog(
            "4a",
            "Barkley",
            DogAge.Adult,
            Breed.Retriever,
            Gender.Male,
            "Black",
            54.0,
            "Columbia City, IN",
            "Intake: Owner Surrender- 2/13/21 he doesn't like the grandkids, he is anxious and they make him uncomfortable\n" +
                "He was originally found by them as a stray\n" +
                "NO SMALL KIDS (15 years +)\n" +
                "TENNIS BALL CRAZY!!!!! He will chase tennis balls to no end!\n" +
                "Knows SIT, STAY, SPEAK, and HIGH FIVE\n" +
                "Energy level: Medium to High\n" +
                "POTTY TRAINED/CRATE TRAINED\n" +
                "Likes car rides\n" +
                "Very social",
            imageId = R.drawable.retriever,
            adoptLink = "https://www.adoptapet.com/pet/30566931-columbia-city-indiana-labrador-retriever"
        )

        return listOf(d, d2, d3, d4, d, d2, d3, d4)
    }
}
