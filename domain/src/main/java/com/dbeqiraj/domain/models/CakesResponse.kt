package com.dibeqiraj.cakeapp.mvp.model

import com.dbeqiraj.domain.base.BaseModel
import com.google.gson.annotations.SerializedName

data class CakesResponse(
    @SerializedName("product")
    val product: String,

    @SerializedName("staffContacts")
    val staffContacts: Array<CakesResponseStaffContacts>,

    @SerializedName("releaseDate")
    val releaseDate: String,

    @SerializedName("cakes")
    val cakes: Array<CakesResponseCakes>,

    @SerializedName("version")
    val version: Int
) : BaseModel()