package com.djmakesapps.countrylist.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.djmakesapps.countrylist.R
import com.djmakesapps.countrylist.adapter.CountryListAdapter
import com.djmakesapps.countrylist.data.Country
import com.djmakesapps.countrylist.viewmodel.CountryViewModel

class CountryListActivity : AppCompatActivity(), CountryListAdapter.OnItemClickListener {

    val TAG = "CountryListActivity"

    lateinit var myAdapter: CountryListAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerViewCountries: RecyclerView

    private val viewModel: CountryViewModel by viewModels()
    private lateinit var progressBar: ProgressBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_country_list)
        progressBar =  findViewById<ProgressBar>(R.id.progress_bar)
        recyclerViewCountries = findViewById(R.id.country_recycler_view)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerViewCountries.layoutManager = linearLayoutManager
        myAdapter = CountryListAdapter(emptyList(), this)
        recyclerViewCountries.adapter = myAdapter

        viewModel.countriesLiveData.observe(this) {
            myAdapter.countryList = it
            myAdapter.notifyDataSetChanged()
            progressBar.isVisible = false
        }

        viewModel.exceptionLiveData.observe(this) {
            progressBar.isVisible = false
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.getCountries()
    }

    override fun onItemClick(position: Country.CountryItem) {
        val intent = Intent(this@CountryListActivity, CountryDetailsActivity::class.java)
        startActivity(intent)
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
