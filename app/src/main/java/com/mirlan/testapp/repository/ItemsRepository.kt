package com.mirlan.testapp.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.mirlan.testapp.database.ItemsDatabase
import com.mirlan.testapp.model.Item
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.Random.Default.nextBoolean

class ItemsRepository(private val itemsDatabase: ItemsDatabase) {
    fun getItems(): LiveData<PagedList<Item>>{
        return itemsDatabase.itemDao().getAll().toLiveData(10)
    }

    fun insertItem(){
        GlobalScope.launch {
            for(i in 0..10000){
                val item = Item(i, nextBoolean(), nextBoolean())
                itemsDatabase.itemDao().insert(item)
            }
        }
    }
    fun getItemCount() = itemsDatabase.itemDao().getItemCount()

}

