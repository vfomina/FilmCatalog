package com.example.filmcatalog.data

import com.example.filmcatalog.R
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Film(
    val id: Int,
    val name: String,
    @Transient var photo_id: Int = R.drawable.ic_launcher_foreground,
    val date_publication: String,
    val rating: Double,
    val description: String,
)