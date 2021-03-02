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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.PetData
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.components.PetDetail
import com.example.androiddevchallenge.ui.components.PetProfile
import com.example.androiddevchallenge.ui.theme.PetTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PetTheme {
                PageNavigation()
            }
        }
    }
}

@Composable
fun HomePage(navController: NavController) {
    val data = PetData()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Find a pet to adopt")
                }
            )
        }
    ) { innerPadding ->
        Surface(color = MaterialTheme.colors.background) {
            PetList(data.getData(), navController, Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun PageNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomePage(navController = navController)
        }
        composable("detail/{petTag}") { backStackEntry ->
            backStackEntry.arguments?.getString("petTag")?.let {
                PetDetail(navController = navController, it)
            }
        }
    }
}


@Composable
fun PetList(pets: List<Dog>, navController: NavController, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = pets) { pet ->
            PetProfile(pet, Modifier.clickable(onClick = {
                navController.navigate("detail/${pet.petTag}")
            }))
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    val navController = rememberNavController()
    PetTheme {
        HomePage(navController)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    val navController = rememberNavController()
    PetTheme(darkTheme = true) {
        HomePage(navController)
    }
}
