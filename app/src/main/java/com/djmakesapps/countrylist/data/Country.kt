package com.djmakesapps.countrylist.data

class Country: ArrayList<Country.CountryItem>() {

    data class CountryItem(
        val capital: String,
        val code: String,
        val flag: String,
        val name: String,
        val region: String
    )
}