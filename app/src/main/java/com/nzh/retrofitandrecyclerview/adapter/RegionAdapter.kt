package com.nzh.retrofitandrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nzh.retrofitandrecyclerview.R
import com.nzh.retrofitandrecyclerview.model.Region

class RegionAdapter(val regionList: ArrayList<Region>):RecyclerView.Adapter<RegionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionViewHolder {
        var  view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout,parent,false)
        return RegionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return regionList.size
    }

    override fun onBindViewHolder(holder: RegionViewHolder, position: Int) {
        holder.txtId.text=regionList[position].id
        holder.txtName.text=regionList[position].region_name
    }
}

class RegionViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    var txtId:TextView=itemView.findViewById(R.id.txt_region_id)
    var txtName:TextView=itemView.findViewById(R.id.txt_region_name)
}
