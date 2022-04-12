package com.android.timetrackingdashboard.buisness.repository

import com.android.timetrackingdashboard.buisness.data.model.TimeData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.lang.reflect.Type


class MainRepository {

//    fun getDataAsync(jsonString: String): List<TimeData>? {
//        try {
//            val collectionType: Type = object : TypeToken<Collection<TimeData?>?>() {}.type
//            return Gson().fromJson(jsonString, collectionType)
//        } catch (e: Exception) {
//        }
//        return null
//    }

    suspend fun getTimeDataAsync(jsonString: String): List<TimeData>? = withContext(Dispatchers.IO)  {
        async {
            try {
                val collectionType: Type = object : TypeToken<Collection<TimeData?>?>() {}.type
                return@async Gson().fromJson(jsonString, collectionType)
            } catch (e: Exception) {
            }
            return@async null
        }
    }.await()

}