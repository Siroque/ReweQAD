package com.example.sin.reweqad.api

import com.example.sin.reweqad.data.EntityResult
import com.google.gson.Gson
import java.net.URL

class EntityRequest() {

    companion object { //1
        private val BASE_URL = "https://api.github.com/search/repositories"
        private val LIST_PATH_URI = "/b/5bcf138b716f9364f8c99075"
        private val COMPLETE_URL = "$BASE_URL?$LIST_PATH_URI"
    }

    fun run(): EntityResult {
        val repoListJsonStr = URL(COMPLETE_URL).readText()
        return Gson().fromJson(repoListJsonStr, EntityResult::class.java)
    }
}