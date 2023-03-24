package com.djmakesapps.countrylist.respository

import com.djmakesapps.countrylist.data.Country
import com.djmakesapps.countrylist.network.NetworkLayer
import com.djmakesapps.countrylist.network.safeApiCall
import com.djmakesapps.countrylist.utils.SimpleResponse

class SharedRepository {

    suspend fun getCountryFromApi() : SimpleResponse<List<Country.CountryItem>> {
        return safeApiCall { NetworkLayer.api.getDataFromAPI() }
    }
}