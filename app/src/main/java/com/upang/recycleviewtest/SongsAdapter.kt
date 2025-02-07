package com.upang.recycleviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView

class SongsAdapter(private val songList: ArrayList<Songs>) : RecyclerView.Adapter<SongsAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SongsAdapter.MyViewHolder, position: Int) {
        val currentItem = songList[position]
        holder.title.setText("Song: ${currentItem.title}")
        holder.artist.setText("Artist: ${currentItem.artist}")
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.tvTitle)
        val artist : TextView = itemView.findViewById(R.id.tvArtist)
    }
}