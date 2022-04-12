package com.android.timetrackingdashboard.buisness.data.model

import com.google.gson.annotations.SerializedName


data class Timeframes(
    @SerializedName("daily") var daily: Daily? = Daily(),
    @SerializedName("weekly") var weekly: Weekly? = Weekly(),
    @SerializedName("monthly") var monthly: Monthly? = Monthly()
)