package com.example.filmcatalog.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.filmcatalog.viewmodel.FilmsViewModel

@Composable
fun FilmDetailScreen(
    filmsViewModel: FilmsViewModel, filmId: Int
) {
    val film = filmsViewModel.getFilmById(filmId)
    if (film != null) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Image(
                    painter = painterResource(id = film.photo_id),
                    contentDescription = " ",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                Text(
                    text = film.name,
                    modifier = Modifier.padding(top = 8.dp, start = 3.dp),
                    fontWeight = FontWeight.Bold,
                )
            }
            item {
                Text(
                    text = film.date_publication,
                    modifier = Modifier.padding(start = 3.dp),
                )
            }
            item {
                Text(
                    text = "${film.rating}/5.0"
                )
            }
            item {
                Text(
                    text = film.description,
                    modifier = Modifier.padding(start = 3.dp),
                )
            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Ошибка. Фильм не найден", modifier = Modifier
            )
        }
    }
}