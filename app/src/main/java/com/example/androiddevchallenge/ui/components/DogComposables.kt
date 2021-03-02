package com.example.androiddevchallenge.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.impl.FakePetsRepository
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.theme.PetTheme


@Composable
fun PetProfile(dog: Dog, modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.onSurface.copy(alpha = 0.5f))

    ) {
        Column(
            Modifier
                .padding(10.dp)
                .align(Alignment.CenterVertically)
        ) {
            Surface(
                modifier = Modifier.size(100.dp),
                shape = RoundedCornerShape(5.dp),
                elevation = 4.dp,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                Image(
                    painter = painterResource(dog.imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }

        Column(
            Modifier
                .padding(start = 10.dp)
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        ) {
            Text(
                dog.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5
            )
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    "${dog.gender}, ${dog.age}",
                    style = MaterialTheme.typography.body1
                )
                Text(
                    dog.location,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun PetDetail(navController: NavController, petTag: String) {
    val repo = FakePetsRepository()
    val pet = repo.getPet(petTag);

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Pet Details")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("home")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Go back to Home page",
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        val scrollState = rememberScrollState()
        val context = LocalContext.current

        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(10.dp)
                    .verticalScroll(scrollState)
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    elevation = 6.dp,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
                ) {
                    Image(
                        painter = painterResource(pet.imageId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(Modifier.height(16.dp))

                DetailHeader("Facts About Me")

                DetailItem("Breed", pet.breed.toString())
                Divider()
                DetailItem("Color", pet.color.toString())
                Divider()
                DetailItem("Age", pet.age.toString())
                Divider()
                DetailItem("Weight", pet.weight.toString())
                Divider()
                DetailItem("Gender", pet.gender.toString())
                Divider()
                DetailItem("Location", pet.location)
                Divider()
                DetailItem("Pet id", pet.petTag.toString())
                Divider()

                Spacer(Modifier.height(16.dp))
                DetailHeader("My Story")
                Text("${pet.details}", style = MaterialTheme.typography.body1)

                Button(
                    modifier = Modifier.padding(10.dp).fillMaxWidth(),
                    onClick = {
                    val browserX = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(pet.adoptLink)
                    )
                    startActivity(context, browserX, null)
                }) {
                    Text("Adopt me!")
                }
            }
        }
    }
}

@Composable
fun DetailHeader(headerText: String) {
    Text(
        "$headerText",
        style = MaterialTheme.typography.h6,
        color = MaterialTheme.colors.primaryVariant,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 5.dp)
    )
}

@Composable
fun DetailItem(headingText: String, itemText: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 3.dp, bottom = 3.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                "$headingText :",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
        }
        Column {
            Text("$itemText", style = MaterialTheme.typography.body1)
        }
    }
}

@Preview
@Composable
fun PetDetailPreview() {
    val navController = rememberNavController()
    PetTheme(darkTheme = false) {
        PetDetail(navController, "1a")
    }
}

@Preview
@Composable
fun PetDetailPreviewDarkMode() {
    val navController = rememberNavController()
    PetTheme(darkTheme = true) {
        PetDetail(navController, "1a")
    }
}