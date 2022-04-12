package com.android.timetrackingdashboard.buisness.data.model

import com.google.gson.annotations.SerializedName


data class Monthly(
    @SerializedName("current") var current: Int? = null,
    @SerializedName("previous") var previous: Int? = null
)