package com.iqbalfauzi.data.model.detail


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class ProductionCountry(
    @Json(name = "iso_3166_1") val iso31661: String = "",
    @Json(name = "name") val name: String = ""
) : Parcelable