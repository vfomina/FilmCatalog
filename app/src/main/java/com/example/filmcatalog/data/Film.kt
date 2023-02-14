package com.example.filmcatalog.data

data class Film(
    val id: Int,
    val name: String,
    val photo_id: Int,
    val date_publication: String,
    val rating: Double,
    val description: String,
)