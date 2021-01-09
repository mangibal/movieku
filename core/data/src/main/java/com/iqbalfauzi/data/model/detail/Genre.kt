package com.iqbalfauzi.data.model.detail


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class Genre(
    @Json(name = "id") val id: Int = 0,
    @Json(name = "name") val name: String = ""
) : Parcelable