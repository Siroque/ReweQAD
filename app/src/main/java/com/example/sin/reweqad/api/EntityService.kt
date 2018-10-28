package com.example.sin.reweqad.api

import com.example.sin.reweqad.data.EntityResult
import retrofit2.Call
import retrofit2.http.GET

interface EntityService {
    @GET("/b/5bcf138b716f9364f8c99075")
    fun retrieveEntities(): Call<EntityResult>
}