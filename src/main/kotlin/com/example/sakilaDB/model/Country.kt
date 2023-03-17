package com.example.sakilaDB.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
import java.sql.Timestamp

class Country (@Id
               @GeneratedValue(strategy= GenerationType.AUTO)
               @JsonProperty("CountryId")
               val countryId: Int,
               @JsonProperty("Country")
               val country: String,
               @JsonProperty("LastUpdate")
               val lastUpdate:Timestamp?=null)