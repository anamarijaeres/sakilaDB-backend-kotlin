package com.example.sakilaDB.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
import java.sql.Timestamp


data class Film(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("FilmId")
    val filmId: Int,
    @JsonProperty("Title")
    val title: String,
    @JsonProperty("Description")
    val description:String?=null,
    @JsonProperty("ReleaseYear")
    val releaseYear: Int=2000,
    @JsonProperty("OriginalLanguageId")
    val originalLanguageId: Int? =null,
    @JsonProperty("LanguageId")
    val languageId:Int=1,
    @JsonProperty("Length")
    val length: Int? =null,
    @JsonProperty("Rating")
    val rating: String="G",
    @JsonProperty("RentalRate")
    val rentalRate:Float?=null,
    @JsonProperty("LastUpdate")
    val lastUpdate: Timestamp?=null)