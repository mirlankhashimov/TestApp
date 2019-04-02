package com.mirlan.testapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

//@Entity(foreignKeys = arrayOf(ForeignKey(entity = Item::class,
//                                    parentColumns = arrayOf("id"),
//                                    childColumns = arrayOf("itemId"),
//                                    onDelete = CASCADE)))
@Entity
class ItemText(
    @PrimaryKey
    val id: Int = 0,
    val text: String? = ""
)