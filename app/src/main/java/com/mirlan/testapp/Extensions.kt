package com.mirlan.testapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import java.util.*

fun <T> diffItemCallback(
    contentsSame: (Pair<T, T>) -> Boolean = { it.first == it.second },
    itemsSame: (Pair<T, T>) -> Boolean
) = object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = itemsSame(Pair(oldItem, newItem))
    override fun areContentsTheSame(oldItem: T, newItem: T) = contentsSame(Pair(oldItem, newItem))
}
fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun getRandomString() : String {
        val allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz"
        return (1..1)
            .map { allowedChars.random() }
            .joinToString("")
}