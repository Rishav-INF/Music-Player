package com.example.music_player

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.music_player.songAdapter.*

class songAdapter(var songview:List<song_class>): RecyclerView.Adapter<songAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var songname= itemView.findViewById<TextView>(R.id.tv1)
        var songdetail= itemView.findViewById<TextView>(R.id.tv2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.per_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
return songview.size    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.songname.text=songview[position].Song
        holder.songdetail.text=songview[position].details

    }
    fun updateList(newList: List<song_class>) {
        songview = newList
        notifyDataSetChanged()
    }


}