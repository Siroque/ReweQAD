package com.example.sin.reweqad.api

import com.example.sin.reweqad.data.EntityResult
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EntityRetriever {
    private val service: EntityService

    companion object {
        const val BASE_URL = "http://api.jsonbin.io/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(EntityService::class.java)
    }

    fun getEntities(callback: Callback<EntityResult>) {
        service.retrieveEntities().enqueue(callback)
    }
}