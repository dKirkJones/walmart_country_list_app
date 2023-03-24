package com.djmakesapps.countrylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.djmakesapps.countrylist.data.Country
import com.djmakesapps.countrylist.databinding.ListItemBinding

class CountryListAdapter (
    var countryList: List<Country.CountryItem> = emptyList(),
    val itemClickListener: OnItemClickListener,

    ): RecyclerView.Adapter<CountryListAdapter.ViewHolder>() {

    inner class ViewHolder( val itemBinding: ListItemBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val countryItem = countryList[position]
        holder.itemBinding.apply {
            tvCountyName.text = countryItem.name
            tvCapital.text = countryItem.capital
            tvRegion.text = countryItem.region
            tvCode.text = countryItem.code
        }
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(countryItem)
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Country.CountryItem)
    }
}