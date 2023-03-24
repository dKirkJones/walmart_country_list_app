package com.djmakesapps.countrylist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djmakesapps.countrylist.data.Country
import com.djmakesapps.countrylist.respository.SharedRepository
import com.djmakesapps.countrylist.utils.SimpleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryViewModel : ViewModel() {

    private val TAG = "CountryViewModel"
    private val repo = SharedRepository()

    private val _countriesLiveData: MutableLiveData<List<Country.CountryItem>> = MutableLiveData()
    val countriesLiveData: LiveData<List<Country.CountryItem>> = _countriesLiveData

    private val _exceptionLiveData: MutableLiveData<String> = MutableLiveData()
    val exceptionLiveData: LiveData<String> = _exceptionLiveData


    fun getCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getCountryFromApi()
            when (response.status) {
                SimpleResponse.Status.Success -> {
                    withContext(Dispatchers.Main) {
                        _countriesLiveData.value = response.body
                    }
                }
                SimpleResponse.Status.Failure -> {
                    withContext(Dispatchers.Main) {
                        _exceptionLiveData.value = response.exception?.message
                    }
                }
            }
        }
    }
}