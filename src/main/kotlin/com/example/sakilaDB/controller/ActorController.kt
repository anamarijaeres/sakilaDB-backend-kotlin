package com.example.sakilaDB.controller

import com.example.sakilaDB.model.Actor
import com.example.sakilaDB.model.Film
import com.example.sakilaDB.service.ActorService
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping("/actors")
class ActorController(val service:ActorService ) {


    @GetMapping("")
    fun listActors(): List<Actor> = service.findActors()

    @PostMapping("")
    fun createActor(@RequestBody actor:Actor){
        service.addActor(actor)
    }

    @GetMapping("/id") // /actors/id?id=2
    fun getActorById(@RequestParam("id") id: Int):List<Actor>{
        return service.getById(id)
    }

    @DeleteMapping("/id") // /actors/id?id=2 delete
    fun deleteActorById(@RequestParam("id") id: Int){
        return service.deleteActorById(id)
    }


    @GetMapping("/search") // /actors/search?s=P
    fun searchActors(@RequestParam("s") s: String):List<Actor>{
        return service.searchActor(s)
    }

    //------------------------------new functionalities--------------------------------------------------------
    @GetMapping("/numfilms")
    fun getNumOfFilmsbyActorId(@RequestParam("id") id: Int): Int? = service.getNumOfFilmsbyActorId(id)

    @GetMapping("/filmsByLength")
    fun getFilmsByLength(@RequestParam("id") id: Int):List<Film>{
        return service.getFilmsByLength(id)
    }
}