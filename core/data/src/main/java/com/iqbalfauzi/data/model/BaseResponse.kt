package com.iqbalfauzi.data.model

import com.squareup.moshi.Json

/**
 * Created by Iqbal Fauzi on 1/6/21 1:00 PM
 * iqbal.fauzi.if99@gmail.com
 */
open class BaseResponse {
    @Json(name = "status_message") val statusMessage: String? = null
    @Json(name = "success") val success: Boolean? = null
    @Json(name = "status_code") val statusCode: Int? = null
}