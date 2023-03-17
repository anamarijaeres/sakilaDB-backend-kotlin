package com.example.sakilaDB.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
import java.sql.Timestamp



class Actor(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("ActorId")
    val actorId: Int,
    @JsonProperty("FirstName")
    val firstName: String,
    @JsonProperty("LastName")
    val lastName:String,
    @JsonProperty("LastUpdate")
    val lastUpdate: Timestamp?=null)
