package com.dbeqiraj.data.repository

import com.dibeqiraj.cakeapp.mvp.model.CakesResponse
import retrofit2.http.GET

interface CakesApiService {
    @GET("/filippella/a728a34822a3bc7add98e477a4057b69/raw/310d712e87941f569074a63fedb675d2b611342a/cakes")
    suspend fun getCakes(): CakesResponse
}