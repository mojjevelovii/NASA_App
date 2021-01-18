package ru.shumilova.mynasaapp.model.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IPictureOfTheDayAPI {
    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String):
           Call<PODServerResponseData>
}