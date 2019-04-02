package com.mirlan.testapp.database.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mirlan.testapp.model.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    fun getAll(): DataSource.Factory<Int, Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    @Query("SELECT COUNT(id) FROM items")
    fun getItemCount(): Int
}