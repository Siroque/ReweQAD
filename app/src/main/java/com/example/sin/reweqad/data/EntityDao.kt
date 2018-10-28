package com.example.sin.reweqad.data

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface EntityDao {
    @Query("SELECT * FROM entities ORDER BY name")
    fun getEntities(): LiveData<List<Entity>>

    @Query("SELECT * FROM entities WHERE criterion = :criterion ORDER BY name")
    fun getEntitiesWithCriterion(criterion: Int): LiveData<List<Entity>>

    @Query("SELECT * FROM entities WHERE id = :entityId")
    fun getEntity(entityId: String): LiveData<Entity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<Entity>)
}