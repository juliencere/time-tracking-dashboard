package com.android.timetrackingdashboard.buisness.data.model

import com.google.gson.annotations.SerializedName


data class TimeData(
    @SerializedName("title") var title: String? = null,
    @SerializedName("timeframes") var timeframes: Timeframes? = Timeframes()
)