package com.mirlan.testapp.ui

import android.media.Image
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mirlan.testapp.R
import com.mirlan.testapp.diffItemCallback
import com.mirlan.testapp.getRandomString
import com.mirlan.testapp.inflate
import com.mirlan.testapp.model.Item
import java.util.concurrent.RecursiveAction

class ItemsAdapter(): PagedListAdapter<Item, RecyclerView.ViewHolder>(
    diffItemCallback{it.first.id == it.second.id}
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == ITEM_TYPE.IMAGE.ordinal)
            return ItemsImageViewHolder(parent.inflate(R.layout.item_image_list))
        return ItemsTextViewHolder(parent.inflate(R.layout.item_text_list))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ItemsTextViewHolder)?.bind(getItem(position))
        (holder as? ItemsImageViewHolder)?.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        if(getItem(position)?.isImage == true)
            return ITEM_TYPE.IMAGE.ordinal
        else
            return ITEM_TYPE.TEXT.ordinal
    }
    inner class ItemsTextViewHolder(v: View): RecyclerView.ViewHolder(v){
        private val name: TextView = itemView.findViewById(R.id.item_name)
        private val linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)

        fun bind(item: Item?){
            //var text = getRandomString()
            if(item?.isRight == false) {
                linearLayout.gravity = Gravity.START
            }else
                linearLayout.gravity = Gravity.END
            name.text = item?.itemText?.text.plus(" - text")

        }
    }
    inner class ItemsImageViewHolder(v: View): RecyclerView.ViewHolder(v){
        private val name: TextView = itemView.findViewById(R.id.item_name)
        private val linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)

        fun bind(item: Item?){
            if(item?.isRight == false)
                linearLayout.gravity = Gravity.START
            else
                linearLayout.gravity = Gravity.END
            name.text = item?.itemText?.text
            }
        }
    }
    enum class ITEM_TYPE{
        IMAGE, TEXT
    }