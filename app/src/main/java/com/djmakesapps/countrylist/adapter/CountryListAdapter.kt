package com.djmakesapps.countrylist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.djmakesapps.countrylist.R
import com.djmakesapps.countrylist.data.Country

class CountryListAdapter (
    var countryList: List<Country.CountryItem> = emptyList(),
    val itemClickListener: OnItemClickListener

): RecyclerView.Adapter<CountryListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName: TextView
        var countryCapital: TextView
        var countryRegion: TextView
        var countryCode: TextView

        init {
            countryName = itemView.findViewById(R.id.tv_county_name)
            countryCapital = itemView.findViewById(R.id.tv_capital)
            countryRegion = itemView.findViewById(R.id.tv_region)
            countryCode = itemView.findViewById(R.id.tv_code)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.countryName.text = countryList[position].name + ","
        holder.countryCapital.text = countryList[position].capital
        holder.countryRegion.text = countryList[position].region
        holder.countryCode.text = countryList[position].code
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(countryList[position])
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Country.CountryItem)
    }

}