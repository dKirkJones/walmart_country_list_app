package com.djmakesapps.countrylist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.djmakesapps.countrylist.databinding.ActivityMainBinding
import com.djmakesapps.countrylist.ui.CountryListActivity

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btGetList.setOnClickListener {
            startActivity(Intent(this, CountryListActivity::class.java))
        }
    }
}