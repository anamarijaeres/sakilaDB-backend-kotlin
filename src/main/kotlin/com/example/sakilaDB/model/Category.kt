package com.example.sakilaDB.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
import java.sql.Timestamp

class Category (
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("CategoryId")
    val categoryId: Int,
    @JsonProperty("Name")
    val name:String,
    @JsonProperty("LastUpdate")
    val lastUpdate: Timestamp
    )