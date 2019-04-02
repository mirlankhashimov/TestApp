package com.mirlan.testapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirlan.testapp.repository.ItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class ItemsViewModel(private val itemsRepository: ItemsRepository): ViewModel(){

    val items = itemsRepository.getItems()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            if (itemsRepository.getItemCount() == 0)
                itemsRepository.insertItem()
        }
    }
}