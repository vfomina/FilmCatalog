package com.example.filmcatalog.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.MyApplication
import com.example.filmcatalog.data.Film
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class FilmsViewModel : ViewModel() {
    fun getFilms() =
        Json.decodeFromString<List<Film>>(loadJsonFromAssets(MyApplication.getInstance()))

    fun getFilmById(filmId: Int): Film? = getFilms().find { it.id == filmId }

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
