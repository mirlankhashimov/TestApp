package com.mirlan.testapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item (
    @PrimaryKey
    val id: Int = 0,
    val isRight: Boolean = false,
    val isImage: Boolean = false
)