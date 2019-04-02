package com.mirlan.testapp.ui

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mirlan.testapp.R
import com.mirlan.testapp.diffItemCallback
import com.mirlan.testapp.getRandomString
import com.mirlan.testapp.inflate
import com.mirlan.testapp.model.Item

class ItemsAdapter(): PagedListAdapter<Item, ItemsAdapter.ItemsViewHolder>(
    diffItemCallback{it.first.id == it.second.id}
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(parent.inflate(R.layout.item_list))
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class ItemsViewHolder(v: View): RecyclerView.ViewHolder(v){
        private val name: TextView = itemView.findViewById(R.id.item_name)
        private val image: ImageView = itemView.findViewById(R.id.item_image)
        fun bind(item: Item?){
            var text = getRandomString()

            if (item?.isImage == true)
                image.visibility = View.VISIBLE
            else {
                text = text.plus(" - text")
                image.visibility = View.GONE
            }
            if(item?.isRight == false) {
                name.gravity = Gravity.START
            }else
                name.gravity = Gravity.END
            name.text = text
        }
    }

}