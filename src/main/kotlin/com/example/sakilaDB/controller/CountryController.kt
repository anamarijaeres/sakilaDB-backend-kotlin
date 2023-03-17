package com.example.sakilaDB.controller


import com.example.sakilaDB.model.City
import com.example.sakilaDB.model.Country
import com.example.sakilaDB.service.CountryService
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping("/country")
class CountryController(val service: CountryService){
    @GetMapping("")
    fun listCountries(): List<Country> = service.findCountries()

    @PostMapping("")
    fun createCountry(@RequestBody country:Country){
        service.addCountry(country)
    }
    @PostMapping("/addCity") // /country/addCity?id=
    fun createCityForCountryId(@RequestParam("id") id: Int,@RequestBody city:City){
        service.addCityForCountryId(city,id)
    }

    @DeleteMapping("/deleteCity") // /country/deleteCity?id=2 delete
    fun deleteCityById(@RequestParam("id") id: Int){
        return service.deleteCityById(id)
    }
    @DeleteMapping("/id") // /country/id?id=2 delete
    fun deleteCountryById(@RequestParam("id") id: Int){
        return service.deleteCountryById(id)
    }

    @GetMapping("/search") // /country/search?s=P
    fun searchCountries(@RequestParam("s") s: String):List<Country>{
        return service.searchCountry(s)
    }

    @GetMapping("/cities")  // /country/cities?id=1
    fun getCitiesByCountryId(@RequestParam("id") id: Int):List<City>{
        return service.getCitiesByCountryId(id)
    }
}