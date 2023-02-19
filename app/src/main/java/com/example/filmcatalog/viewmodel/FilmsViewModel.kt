package com.example.filmcatalog.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.MyApplication
import com.example.filmcatalog.R
import com.example.filmcatalog.data.Film
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class FilmsViewModel : ViewModel() {
    fun getFilms() =
        Json
            .decodeFromString<List<Film>>(loadJsonFromAssets(MyApplication.getInstance()))
            .mapIdToImageId()

    fun getFilmById(filmId: Int): Film? = getFilms().find { it.id == filmId }

    private fun List<Film>.mapIdToImageId() = map { film ->
        when (film.id) {
            0 -> film.photo_id = R.drawable.film_img_0
            1 -> film.photo_id = R.drawable.film_img_1
            2 -> film.photo_id = R.drawable.film_img_2
            3 -> film.photo_id = R.drawable.film_img_3
            4 -> film.photo_id = R.drawable.film_img_4
            5 -> film.photo_id = R.drawable.film_img_5
        }; film
    }

    private fun loadJsonFromAssets(context: Context): String {
        var result = ""

        runCatching {
            val input = context.assets.open("sample.json")
            val size = input.available()
            val bytes = ByteArray(size)
            input.read(bytes)
            input.close()
            result = String(bytes)
        }.onFailure {
            it.printStackTrace()
        }

        return result
    }
}
