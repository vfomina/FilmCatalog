package com.example.filmcatalog

import com.example.filmcatalog.viewmodel.FilmsViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.filmcatalog.compose.FilmDetailScreen
import com.example.filmcatalog.data.Film
import com.example.filmcatalog.ui.theme.FilmCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: FilmsViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContent {
            FilmCatalogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    FilmsNavHost(viewModel)
                }
            }
        }
    }
}

@Composable
fun FilmsNavHost(filmsViewModel: FilmsViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = "list"
    ) {
        composable("list") {
            FilmListScreen(
                navController,
                films = filmsViewModel.filmList,
            )
        }
        composable(
            "details/{filmId}", arguments = listOf(navArgument("filmId") { type = NavType.IntType })
        ) { backStackEntry ->
            FilmDetailScreen(
                navController, filmsViewModel, backStackEntry.arguments?.getInt("filmId") ?: 0
            )
        }
    }
}

@Composable
fun FilmListScreen(navController: NavHostController, films: List<Film>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()
    ) {
        items(films) { film ->
            FilmCard(film = film, navController)
        }
    }
}

@Composable
fun FilmCard(film: Film, navController: NavHostController) {
    Card(modifier = Modifier
        .fillMaxSize()
        .clickable { navController.navigate("details/${film.id}") }) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
        ) {
            Image(
                painter = painterResource(id = film.photo_id),
                contentDescription = " ",
                modifier = Modifier
                    .width(150.dp)
                    .height(216.dp)
            )
            Text(
                text = film.name,
                modifier = Modifier.padding(top = 8.dp, start = 3.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = film.date_publication,
                modifier = Modifier.padding(start = 3.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FilmCatalogTheme {}
}