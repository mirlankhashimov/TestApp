package com.mirlan.testapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mirlan.testapp.database.dao.ItemDao
import com.mirlan.testapp.model.Item

@Database(version = 2, entities = [Item::class])
abstract class ItemsDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDao
}