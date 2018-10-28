package com.example.sin.reweqad.utilities

import android.content.Context
import com.example.sin.reweqad.data.AppDatabase
import com.example.sin.reweqad.data.EntityRepository
import com.example.sin.reweqad.viewmodels.EntityListViewModelFactory

object InjectorUtils {

    private fun getEntityRepository(context: Context): EntityRepository {
        return EntityRepository.getInstance(AppDatabase.getInstance(context).entityDao())
    }

    fun provideEntityListViewModelFactory(context: Context): EntityListViewModelFactory {
        val repository = getEntityRepository(context)
        return EntityListViewModelFactory(repository)
    }
}