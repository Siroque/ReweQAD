package com.example.sin.reweqad.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "entities")
data class Entity(
    @PrimaryKey @ColumnInfo(name = "id") val entityId: String,
    val name: String?,
    val warranty: Date?,
    val criterion: Int,
    val created: Date
) {
    override fun toString() = name.orEmpty()
}

data class EntityResult(val items: List<com.example.sin.reweqad.data.Entity>)