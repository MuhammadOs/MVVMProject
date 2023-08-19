package com.example.myproject.Data.Network

import retrofit2.http.GET

interface NetworkService {
    @GET("quotes")
    suspend fun getQuotes() : QuotesModel
}