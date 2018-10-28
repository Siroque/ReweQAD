package com.example.sin.reweqad.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sin.reweqad.data.Entity
import com.example.sin.reweqad.data.EntityRepository

class EntityListViewModel internal constructor(
    private val entityRepository: EntityRepository
) : ViewModel()  {
    private val criterion = MutableLiveData<Int>()

    private val entityList = MediatorLiveData<List<Entity>>()

    init {
        criterion.value = DEFAULT_LIST

        val liveEntityList = Transformations.switchMap(criterion) {
            if (it == DEFAULT_LIST) {
                entityRepository.getEntities()
            } else {
                entityRepository.getEntitiesWithCriterion(it)
            }
        }
        entityList.addSource(liveEntityList, entityList::setValue)
    }

    fun getEntities() = entityList

    fun setCriterion(num: Int) {
        if (num in 0..1) //TODO: get distinct values for criterion field from DB and check against them?
            criterion.value = num
        else
            clearCriterion()
    }

    private fun clearCriterion() {
        criterion.value = DEFAULT_LIST
    }

    fun isFiltered() = criterion.value != DEFAULT_LIST

    companion object {
        private const val DEFAULT_LIST = -1
    }
}