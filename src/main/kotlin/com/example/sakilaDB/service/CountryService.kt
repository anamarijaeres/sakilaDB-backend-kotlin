package com.example.sakilaDB.service
import com.example.sakilaDB.model.Country
import com.example.sakilaDB.model.City
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class CountryService(val db: JdbcTemplate) {

    fun findCountries(): List<Country> =db.query("select * from country") {
            response,_->
        Country(response.getInt("country_id"),response.getString("country"),response.getTimestamp("last_update"))
    }


    fun searchCountry(s: String): List<Country> = db.query("select * from country where country LIKE '$s%'") {
        response,_->Country(response.getInt("country_id"),response.getString("country"),response.getTimestamp("last_update"))

    }

    fun getCitiesByCountryId(id: Int): List<City> = db.query("select * from city where country_id=$id") {
            response,_->
        City(response.getInt("city_id"),response.getInt("country_id"),response.getString("city"),response.getTimestamp("last_update"))

    }

    fun addCountry(country: Country) {
        db.update("insert into country (country_id,country) values (?,?)", country.countryId,country.country)

    }

    fun deleteCountryById(id: Int) {
        db.update("delete from country where country_id=$id")
    }

    fun addCityForCountryId(city: City, id: Int) {
        db.update("insert into city (city, city_id, country_id) values (?,?,?)", city.city,city.cityId,id)

    }

    fun deleteCityById(id: Int) {
        db.update("delete from city where city_id=$id")
    }
}