package com.example.sakilaDB.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
import java.sql.Timestamp

class City(@Id
           @GeneratedValue(strategy= GenerationType.AUTO)
           @JsonProperty("CityId")
           val cityId: Int,
           @JsonProperty("CountryId")
           val countryId: Int,
           @JsonProperty("City")
           val city: String,
           @JsonProperty("LastUpdate")
           val lastUpdate: Timestamp?=null
)