/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data.impl

import com.example.androiddevchallenge.data.PetData
import com.example.androiddevchallenge.data.PetRepository
import com.example.androiddevchallenge.model.Dog

class FakePetsRepository : PetRepository {
    override fun getPet(petTag: String): Dog {
        val data = PetData()
        val pets = data.getData()
        val pet = pets.find { it.petTag == petTag }
        return pet!!
    }

    override fun getPets(): List<Dog> {
        val data = PetData()
        return data.getData()
    }
}
