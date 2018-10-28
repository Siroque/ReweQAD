package com.example.sin.reweqad.workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.sin.reweqad.api.EntityRetriever
import com.example.sin.reweqad.data.AppDatabase
import com.example.sin.reweqad.data.Entity
import com.example.sin.reweqad.data.EntityResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeedDatabaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }
    private val entityRetriever = EntityRetriever()

    override fun doWork(): Result {
        return try {
            entityRetriever.getEntities(apiCallback)
            Result.SUCCESS
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.FAILURE
        }
    }

    private val apiCallback = object : Callback<EntityResult> {
        override fun onFailure(call: Call<EntityResult>?, t: Throwable?) {
            Log.e(TAG, "Problem calling the API", t)
        }

        override fun onResponse(call: Call<EntityResult>?, response: Response<EntityResult>?) {
            response?.isSuccessful.let {
                val resultList = EntityResult(response?.body()?.items ?: emptyList())
                val entityList: List<Entity> = resultList.items
                val database = AppDatabase.getInstance(applicationContext)
                database.entityDao().insertAll(entityList)
            }
        }
    }
}