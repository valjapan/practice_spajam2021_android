package com.valjapan.spajampracticeandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.valjapan.spajampracticeandroid.R

class CustomAdapter:RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    val titles = arrayOf(
        "YouTube",
        "Instagram",
        "Facebook",
        "Slack",
        "Twitter",
        "Discord",
        "Teams")

    val details = arrayOf(
        "Red White",
        "Pink Purple Orange",
        "Blue White",
        "White Green Lightblue Red",
        "Blue White",
        "Blue White")

    /*val images = intArrayOf(R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground)*/

    val ids = arrayOf(
        "aaaa",
        "bbbb",
        "cccc",
        "dddd",
        "eeee",
        "ffff")

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemId.text = ids[i]
        //viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount():Int{
        return titles.size
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        //var itemImage:ImageView
        var itemTitle:TextView
        var itemId: TextView
        var itemDetail:TextView

        init {
            //itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detal)
            itemId = itemView.findViewById(R.id.item_id)
        }
    }
}