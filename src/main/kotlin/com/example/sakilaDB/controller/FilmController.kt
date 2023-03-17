package com.example.sakilaDB.controller

import com.example.sakilaDB.model.Category
import com.example.sakilaDB.model.Film
import com.example.sakilaDB.service.FilmService
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping("/films")
class FilmController(val service: FilmService) {

    @GetMapping("")
    fun listFilms(): List<Film> = service.findFilms()

    @PostMapping("")
    fun createFilm(@RequestBody film:Film){
        service.addFilm(film)
    }

    @GetMapping("/id") // /films/id?id=2
    fun getFilmbyId(@RequestParam("id") id: Int):List<Film>{
        return service.getById(id)
    }
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/search") // /films/search?s=P
    fun searchFilms(@RequestParam("s") s: String):List<Film>{
        return service.searchFilm(s)
    }

    @GetMapping("/rating") // /films/rating?rating=PG
    fun listByRating(@RequestParam("rating") rating: String):List<Film>{
        return service.listFilmsByRating(rating)
    }

    @GetMapping("/rent") // /films/rent?rent=1.99
    fun listByRating(@RequestParam("rent") rent: Float):List<Film>{
        return service.listFilmsByRent(rent)
    }

    //------------------------------new functionality--------------------------------------------------------
    @GetMapping("/category") // /films/category?id=1
    fun getCategoryById(@RequestParam("id") id: Int):List<Category>{
        return service.getCategoryByFilmId(id)
    }



}