package com.djmakesapps.countrylist.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.djmakesapps.countrylist.databinding.ActivityCountryDetailsBinding
import com.djmakesapps.countrylist.viewmodel.CountryDetailsViewModel

class CountryDetailsActivity  : AppCompatActivity() {
    val TAG ="Country Details"
    private lateinit var binding: ActivityCountryDetailsBinding

    val _countryViewModel: CountryDetailsViewModel by lazy {
        ViewModelProvider(this)[CountryDetailsViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}