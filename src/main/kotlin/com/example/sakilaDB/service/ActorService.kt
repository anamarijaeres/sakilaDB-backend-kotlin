package com.example.sakilaDB.service

import com.example.sakilaDB.model.Actor
import com.example.sakilaDB.model.Film

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service


@Service
class ActorService(val db: JdbcTemplate) {
    fun findActors(): List<Actor> =db.query("select * from actor") {
            response,_->
        Actor(response.getInt("actor_id"),response.getString("first_name"),response.getString("last_name"),response.getTimestamp("last_update"))
    }

    fun addActor(actor: Actor) {
        db.update("insert into actor (actor_id,first_name,last_name) values (?,?,?)", actor.actorId,actor.firstName,actor.lastName)
    }

    fun getById(id: Int): List<Actor> =db.query("select * from actor where actor_id=$id") {
            response,_->
        Actor(response.getInt("actor_id"),response.getString("first_name"),response.getString("last_name"),response.getTimestamp("last_update"))
    }

    fun searchActor(s: String): List<Actor>  =db.query("select * from actor where first_name LIKE '$s%'") {
            response,_->        Actor(response.getInt("actor_id"),response.getString("first_name"),response.getString("last_name"),response.getTimestamp("last_update"))

    }

    fun deleteActorById(id: Int) {
        db.update("delete from actor where actor_id=$id")

    }

    fun getNumOfFilmsbyActorId(id: Int): Int? {
        return db.queryForObject("SELECT COUNT(*) FROM film_actor AS f JOIN actor AS a ON f.actor_id = a.actor_id WHERE a.actor_id=$id",
            Int::class.java
        )

    }

    fun getFilmsByLength(id: Int): List<Film> = db.query("select * from film as f join film_actor as fa on f.film_id=fa.film_id join actor as a on a.actor_id=fa.actor_id WHERE a.actor_id=1 order by length desc;"){
            response,_->Film(response.getInt("film_id"),response.getString("title"), response.getString("description"), response.getInt("release_year"),response.getInt("original_language_id"), response.getInt("language_id"),response.getInt("length"),response.getString("rating"),response.getFloat("rental_rate"),response.getTimestamp("last_update"))
    }








}


