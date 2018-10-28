package com.example.sin.reweqad.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sin.reweqad.data.EntityRepository

class EntityListViewModelFactory(
    private val repository: EntityRepository
) : ViewModelProvider.NewInstanceFactory()  {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = EntityListViewModel(repository) as T
}