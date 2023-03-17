package com.example.sakilaDB.service

import com.example.sakilaDB.model.Category
import com.example.sakilaDB.model.Film
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class FilmService(val db: JdbcTemplate) {
    fun findFilms(): List<Film> =db.query("select * from film") {
            response,_->Film(response.getInt("film_id"),response.getString("title"), response.getString("description"), response.getInt("release_year"),response.getInt("original_language_id"), response.getInt("language_id"),response.getInt("length"),response.getString("rating"),response.getFloat("rental_rate"),response.getTimestamp("last_update"))
    }

    fun addFilm(film: Film){
        System.out.println(film.languageId)
        System.out.println(film.filmId)
        db.update("insert into film (film_id,title,language_id) values (?,?,?)", film.filmId,film.title,film.languageId)
    }

    fun getById(id:Int): List<Film> =db.query("select * from film where film_id=$id") {
            response,_->Film(response.getInt("film_id"),response.getString("title"), response.getString("description"), response.getInt("release_year"),response.getInt("original_language_id"), response.getInt("language_id"),response.getInt("length"),response.getString("rating"),response.getFloat("rental_rate"),response.getTimestamp("last_update"))
    }

    fun searchFilm(s: String): List<Film>  =db.query("select * from film where title LIKE '$s%'") {
            response,_->Film(response.getInt("film_id"),response.getString("title"), response.getString("description"), response.getInt("release_year"),response.getInt("original_language_id"), response.getInt("language_id"),response.getInt("length"),response.getString("rating"),response.getFloat("rental_rate"),response.getTimestamp("last_update"))
    }

    fun listFilmsByRating(rating: String): List<Film> =db.query("select * from film where rating LIKE '$rating%'") {
            response,_->Film(response.getInt("film_id"),response.getString("title"), response.getString("description"), response.getInt("release_year"),response.getInt("original_language_id"), response.getInt("language_id"),response.getInt("length"),response.getString("rating"),response.getFloat("rental_rate"),response.getTimestamp("last_update"))
    }

    fun listFilmsByRent(rent: Float): List<Film> =db.query("select * from film where rental_rate<=$rent") {
            response,_->Film(response.getInt("film_id"),response.getString("title"), response.getString("description"), response.getInt("release_year"),response.getInt("original_language_id"), response.getInt("language_id"),response.getInt("length"),response.getString("rating"),response.getFloat("rental_rate"),response.getTimestamp("last_update"))
    }

    fun getCategoryByFilmId(id: Int): List<Category> =db.query("SELECT * FROM category where category_id=(Select category_id from film_category where film_id=(select film_id from film where film_id=$id))") {
            response,_->Category(response.getInt("category_id"),response.getString("name"),response.getTimestamp("last_update"))
    }

}