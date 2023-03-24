package com.djmakesapps.countrylist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.djmakesapps.countrylist.data.Country

class CountryDetailsViewModel : ViewModel() {

    private val _countryDetail: MutableLiveData<Country.CountryItem> = MutableLiveData()
    val countryDetail: LiveData<Country.CountryItem> = _countryDetail

    // I would use this to fill in the Details screen for each Country
    fun setCountryDetails(countryItem: Country.CountryItem) {
        _countryDetail.value = countryItem
    }
}