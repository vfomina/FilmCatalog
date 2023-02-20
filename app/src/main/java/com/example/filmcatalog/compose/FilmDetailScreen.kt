package com.example.filmcatalog.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.filmcatalog.data.Film
import com.example.filmcatalog.viewmodel.FilmsViewModel

@Composable
fun FilmDetailScreen(
    filmsViewModel: FilmsViewModel, filmId: Int
) {
    filmsViewModel.getFilmById(filmId)?.let { film ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = film.photo_id),
                contentDescription = " ",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 646.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(color = Color.White)
                    .align(Alignment.BottomCenter)
                    .padding(20.dp)
            ) {
                item {
                    FilmInfo(film = film)
                }
            }
        }
    }
}

@Composable
fun FilmInfo(film: Film) {
    Text(
        text = film.name,
        modifier = Modifier.padding(top = 8.dp, start = 3.dp),
        fontWeight = FontWeight.Bold,
    )
    Text(
        text = film.date_publication,
        modifier = Modifier.padding(start = 3.dp),
    )
    Text(
        text = "${film.rating}/5.0"
    )
    Text(
        text = film.description,
        modifier = Modifier.padding(start = 3.dp),
    )

}