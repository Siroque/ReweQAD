package com.example.sin.reweqad.data

class EntityRepository private constructor(private val entityDao: EntityDao) {

    fun getEntities() = entityDao.getEntities()

    fun getEntity(entityId: String) = entityDao.getEntity(entityId)

    fun getEntitiesWithCriterion(criterion: Int) =
        entityDao.getEntitiesWithCriterion(criterion)

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: EntityRepository? = null

        fun getInstance(entityDao: EntityDao) =
            instance ?: synchronized(this) {
                instance ?: EntityRepository(entityDao).also { instance = it }
            }
    }
}