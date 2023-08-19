package com.example.myproject.Data.Network

data class QuotesModel(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)